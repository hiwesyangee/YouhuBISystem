package engine;

import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.util.Bytes;
import properties.DataProcessProperties;
import utils.JavaHBaseUtils;
import utils.MyUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取统计相关数据的方法，目标————对外接口
 */
public class StatInterface {
    /**
     * 获取一天金额相关数据
     *
     * @param time1
     * @return
     */
    public static List<Stat> getDayStat(String time1) {
        List<Stat> list = new ArrayList<>();
        try {
            Result r = JavaHBaseUtils.getRow(DataProcessProperties.USERSACTIONDAYSTATTABLE, time1);
            String rowkey = time1;
            String apr = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONDAYSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONDAYSTATTABLE[6])));
            if (apr == null) {
                apr = "0";
            }
            String npr = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONDAYSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONDAYSTATTABLE[7])));
            if (npr == null) {
                npr = "0";
            }
            String aARPU = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONDAYSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONDAYSTATTABLE[8])));
            if (aARPU == null) {
                aARPU = "0";
            }
            String aARPPU = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONDAYSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONDAYSTATTABLE[9])));
            if (aARPPU == null) {
                aARPPU = "0";
            }
            String nARPU = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONDAYSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONDAYSTATTABLE[10])));
            if (nARPU == null) {
                nARPU = "0";
            }
            String nARPPU = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONDAYSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONDAYSTATTABLE[11])));
            if (nARPPU == null) {
                nARPPU = "0";
            }
            String appc = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONDAYSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONDAYSTATTABLE[12])));
            if (appc == null) {
                appc = "0";
            }
            String apcc = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONDAYSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONDAYSTATTABLE[13])));
            if (apcc == null) {
                apcc = "0";
            }
            String nppc = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONDAYSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONDAYSTATTABLE[14])));
            if (nppc == null) {
                nppc = "0";
            }
            String npcc = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONDAYSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONDAYSTATTABLE[15])));
            if (npcc == null) {
                npcc = "0";
            }
            list.add(new Stat(rowkey, apr, npr, aARPU, aARPPU, nARPU, nARPPU, appc, apcc, nppc, npcc));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 获取多天金额相关数据
     *
     * @param time1
     * @param time2
     * @return
     */
    public static List<Stat> getManyDayStat(String time1, String time2) {
        List<Stat> list = new ArrayList<>();

        List<String> dateList = MyUtils.checkTime(time1, time2);
        try {
            for (String date : dateList) {
                Result r = JavaHBaseUtils.getRow(DataProcessProperties.USERSACTIONDAYSTATTABLE, date);
                String apr = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONDAYSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONDAYSTATTABLE[6])));
                if (apr == null) {
                    apr = "0";
                }
                String npr = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONDAYSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONDAYSTATTABLE[7])));
                if (npr == null) {
                    npr = "0";
                }
                String aARPU = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONDAYSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONDAYSTATTABLE[8])));
                if (aARPU == null) {
                    aARPU = "0";
                }
                String aARPPU = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONDAYSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONDAYSTATTABLE[9])));
                if (aARPPU == null) {
                    aARPPU = "0";
                }
                String nARPU = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONDAYSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONDAYSTATTABLE[10])));
                if (nARPU == null) {
                    nARPU = "0";
                }
                String nARPPU = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONDAYSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONDAYSTATTABLE[11])));
                if (nARPPU == null) {
                    nARPPU = "0";
                }
                String appc = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONDAYSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONDAYSTATTABLE[12])));
                if (appc == null) {
                    appc = "0";
                }
                String apcc = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONDAYSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONDAYSTATTABLE[13])));
                if (apcc == null) {
                    apcc = "0";
                }
                String nppc = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONDAYSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONDAYSTATTABLE[14])));
                if (nppc == null) {
                    nppc = "0";
                }
                String npcc = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONDAYSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONDAYSTATTABLE[15])));
                if (npcc == null) {
                    npcc = "0";
                }
                String row = date;
                list.add(new Stat(row, apr, npr, aARPU, aARPPU, nARPU, nARPPU, appc, apcc, nppc, npcc));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    /**
     * 获取一月金额相关数据
     *
     * @param time1
     * @return
     */
    public static List<Stat> getMonthStat(String time1) {
        List<Stat> list = new ArrayList<>();
        try {
            Result r = JavaHBaseUtils.getRow(DataProcessProperties.USERSACTIONMONTHSTATTABLE, time1);
            String rowkey = time1;
            String apr = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[6])));
            if (apr == null) {
                apr = "0";
            }
            String npr = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[7])));
            if (npr == null) {
                npr = "0";
            }
            String aARPU = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[8])));
            if (aARPU == null) {
                aARPU = "0";
            }
            String aARPPU = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[9])));
            if (aARPPU == null) {
                aARPPU = "0";
            }
            String nARPU = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[10])));
            if (nARPU == null) {
                nARPU = "0";
            }
            String nARPPU = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[11])));
            if (nARPPU == null) {
                nARPPU = "0";
            }
            String appc = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[12])));
            if (appc == null) {
                appc = "0";
            }
            String apcc = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[13])));
            if (apcc == null) {
                apcc = "0";
            }
            String nppc = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[14])));
            if (nppc == null) {
                nppc = "0";
            }
            String npcc = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[15])));
            if (npcc == null) {
                npcc = "0";
            }
            list.add(new Stat(rowkey, apr, npr, aARPU, aARPPU, nARPU, nARPPU, appc, apcc, nppc, npcc));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 获取多月金额相关数据
     *
     * @param time1
     * @param time2
     * @return
     */
    public static List<Stat> getManyMonthStat(String time1, String time2) {
        List<Stat> list = new ArrayList<>();
        ResultScanner rs = JavaHBaseUtils.getScanner(DataProcessProperties.USERSACTIONMONTHSTATTABLE, time1, time2);
        for (Result r : rs) {
            String rowkey = Bytes.toString(r.getRow());
            String apr = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[6])));
            if (apr == null) {
                apr = "0";
            }
            String npr = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[7])));
            if (npr == null) {
                npr = "0";
            }
            String aARPU = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[8])));
            if (aARPU == null) {
                aARPU = "0";
            }
            String aARPPU = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[9])));
            if (aARPPU == null) {
                aARPPU = "0";
            }
            String nARPU = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[10])));
            if (nARPU == null) {
                nARPU = "0";
            }
            String nARPPU = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[11])));
            if (nARPPU == null) {
                nARPPU = "0";
            }
            String appc = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[12])));
            if (appc == null) {
                appc = "0";
            }
            String apcc = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[13])));
            if (apcc == null) {
                apcc = "0";
            }
            String nppc = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[14])));
            if (nppc == null) {
                nppc = "0";
            }
            String npcc = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[15])));
            if (npcc == null) {
                npcc = "0";
            }
            list.add(new Stat(rowkey, apr, npr, aARPU, aARPPU, nARPU, nARPPU, appc, apcc, nppc, npcc));
        }
        try {
            Result r = JavaHBaseUtils.getRow(DataProcessProperties.USERSACTIONMONTHSTATTABLE, time2);
            String apr = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[6])));
            if (apr == null) {
                apr = "0";
            }
            String npr = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[7])));
            if (npr == null) {
                npr = "0";
            }
            String aARPU = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[8])));
            if (aARPU == null) {
                aARPU = "0";
            }
            String aARPPU = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[9])));
            if (aARPPU == null) {
                aARPPU = "0";
            }
            String nARPU = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[10])));
            if (nARPU == null) {
                nARPU = "0";
            }
            String nARPPU = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[11])));
            if (nARPPU == null) {
                nARPPU = "0";
            }
            String appc = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[12])));
            if (appc == null) {
                appc = "0";
            }
            String apcc = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[13])));
            if (apcc == null) {
                apcc = "0";
            }
            String nppc = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[14])));
            if (nppc == null) {
                nppc = "0";
            }
            String npcc = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[15])));
            if (npcc == null) {
                npcc = "0";
            }
            list.add(new Stat(time2, apr, npr, aARPU, aARPPU, nARPU, nARPPU, appc, apcc, nppc, npcc));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
