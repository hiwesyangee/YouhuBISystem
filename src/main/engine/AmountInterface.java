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
 * 获取金额相关数据的方法，目标————对外接口
 */
public class AmountInterface {
    /**
     * 获取一天金额相关数据
     *
     * @param time1
     * @return
     */
    public static List<Amount> getDayAmount(String time1) {
        List<Amount> list = new ArrayList<>();
        try {
            Result r = JavaHBaseUtils.getRow(DataProcessProperties.USERSACTIONDAYSTATTABLE, time1);
            String rowkey = time1;
            String tpm = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONDAYSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONDAYSTATTABLE[0])));
            if (tpm == null) {
                tpm = "0";
            }
            String tcm = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONDAYSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONDAYSTATTABLE[1])));
            if (tcm == null) {
                tcm = "0";
            }
            String apm = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONDAYSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONDAYSTATTABLE[2])));
            if (apm == null) {
                apm = "0";
            }
            String acm = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONDAYSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONDAYSTATTABLE[3])));
            if (acm == null) {
                acm = "0";
            }
            String npm = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONDAYSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONDAYSTATTABLE[4])));
            if (npm == null) {
                npm = "0";
            }
            String ncm = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONDAYSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONDAYSTATTABLE[5])));
            if (ncm == null) {
                ncm = "0";
            }
            list.add(new Amount(rowkey, tpm, tcm, apm, acm, npm, ncm));
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
    public static List<Amount> getManyDayAmount(String time1, String time2) {
        List<Amount> list = new ArrayList<>();
        List<String> dateList = MyUtils.checkTime(time1, time2);
        try {
            for (String date : dateList) {
                Result r = JavaHBaseUtils.getRow(DataProcessProperties.USERSACTIONDAYSTATTABLE, date);
                String tpm = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONDAYSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONDAYSTATTABLE[0])));
                if (tpm == null) {
                    tpm = "0";
                }
                String tcm = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONDAYSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONDAYSTATTABLE[1])));
                if (tcm == null) {
                    tcm = "0";
                }
                String apm = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONDAYSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONDAYSTATTABLE[2])));
                if (apm == null) {
                    apm = "0";
                }
                String acm = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONDAYSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONDAYSTATTABLE[3])));
                if (acm == null) {
                    acm = "0";
                }
                String npm = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONDAYSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONDAYSTATTABLE[4])));
                if (npm == null) {
                    npm = "0";
                }
                String ncm = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONDAYSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONDAYSTATTABLE[5])));
                if (ncm == null) {
                    ncm = "0";
                }
                String row = date;
                list.add(new Amount(row, tpm, tcm, apm, acm, npm, ncm));
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
    public static List<Amount> getMonthAmount(String time1) {
        List<Amount> list = new ArrayList<>();
        try {
            Result r = JavaHBaseUtils.getRow(DataProcessProperties.USERSACTIONMONTHSTATTABLE, time1);
            String rowkey = time1;
            String tpm = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[0])));
            if (tpm == null) {
                tpm = "0";
            }
            String tcm = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[1])));
            if (tcm == null) {
                tcm = "0";
            }
            String apm = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[2])));
            if (apm == null) {
                apm = "0";
            }
            String acm = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[3])));
            if (acm == null) {
                acm = "0";
            }
            String npm = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[4])));
            if (npm == null) {
                npm = "0";
            }
            String ncm = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[5])));
            if (ncm == null) {
                ncm = "0";
            }
            list.add(new Amount(rowkey, tpm, tcm, apm, acm, npm, ncm));
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
    public static List<Amount> getManyMonthAmount(String time1, String time2) {
        List<Amount> list = new ArrayList<>();
        ResultScanner rs = JavaHBaseUtils.getScanner(DataProcessProperties.USERSACTIONMONTHSTATTABLE, time1, time2);
        for (Result r : rs) {
            String rowkey = Bytes.toString(r.getRow());
            String tpm = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[0])));
            if (tpm == null) {
                tpm = "0";
            }
            String tcm = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[1])));
            if (tcm == null) {
                tcm = "0";
            }
            String apm = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[2])));
            if (apm == null) {
                apm = "0";
            }
            String acm = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[3])));
            if (acm == null) {
                acm = "0";
            }
            String npm = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[4])));
            if (npm == null) {
                npm = "0";
            }
            String ncm = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[5])));
            if (ncm == null) {
                ncm = "0";
            }
            list.add(new Amount(rowkey, tpm, tcm, apm, acm, npm, ncm));
        }
        try {
            Result r = JavaHBaseUtils.getRow(DataProcessProperties.USERSDAYTYPENUMBERTABLE, time2);
            String tpm = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[0])));
            if (tpm == null) {
                tpm = "0";
            }
            String tcm = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[1])));
            if (tcm == null) {
                tcm = "0";
            }
            String apm = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[2])));
            if (apm == null) {
                apm = "0";
            }
            String acm = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[3])));
            if (acm == null) {
                acm = "0";
            }
            String npm = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[4])));
            if (npm == null) {
                npm = "0";
            }
            String ncm = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSACTIONMONTHSTATTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSACTIONMONTHSTATTABLE[5])));
            if (ncm == null) {
                ncm = "0";
            }
            list.add(new Amount(time2, tpm, tcm, apm, acm, npm, ncm));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
