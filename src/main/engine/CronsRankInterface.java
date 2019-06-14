package engine;

import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.util.Bytes;
import properties.DataProcessProperties;
import utils.JavaHBaseUtils;
import utils.MyUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CronsRankInterface {
    /**
     * 获取一天消费排行相关数据
     *
     * @param time1
     * @return
     */
    public static List<CronsRank> getDayRank(String time1) {
        return getManyDayRank(time1, time1);
    }

    /**
     * 获取多天消费排行相关数据
     *
     * @param time1
     * @param time2
     * @return
     */
    public static List<CronsRank> getManyDayRank(String time1, String time2) {
        List<CronsRank> list = new ArrayList<>();
        Map<String, String> cronsMap = new HashMap<>();
        // 按照value排行，将用户充值数据存储到Map中
        String start = time1 + "_0";
        String stop = time2 + "_9999999";
        ResultScanner scanner = JavaHBaseUtils.getScanner(DataProcessProperties.USERSPAYCRONSDAYAMOUNTTABLE, start, stop);
        for (Result r : scanner) {
            String row = Bytes.toString(r.getRow());
            String crons = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSPAYCRONSDAYAMOUNTTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSPAYCRONSDAYAMOUNTTABLE[1])));
            if (crons == null) {
                crons = "0";
            }
            String user = row.split("_")[1];
            cronsMap.put(user, crons);
        }
        Map<String, String> resultMap = MyUtils.sortMapByValue(cronsMap);
        list.add(new CronsRank(time1, resultMap));
        return list;
    }
}
