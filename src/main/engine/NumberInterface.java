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
 * 获取人数相关数据的方法，目标————对外接口
 */
public class NumberInterface {
    /**
     * 获取一天人数相关数据
     *
     * @param time1
     * @return
     */
    public static List<Number> getDayNumber(String time1) {
        List<Number> list = new ArrayList<>();
        try {
            Result result = JavaHBaseUtils.getRow(DataProcessProperties.USERSDAYTYPENUMBERTABLE, time1);
            String rowkey = time1;
            String active = Bytes.toString(result.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSDAYTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSDAYTYPENUMBERTABLE[0])));
            if (active == null) {
                active = "0";
            }
            String activePay = Bytes.toString(result.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSDAYTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSDAYTYPENUMBERTABLE[1])));
            if (activePay == null) {
                activePay = "0";
            }
            String activeCrons = Bytes.toString(result.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSDAYTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSDAYTYPENUMBERTABLE[2])));
            if (activeCrons == null) {
                activeCrons = "0";
            }
            String nNew = Bytes.toString(result.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSDAYTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSDAYTYPENUMBERTABLE[3])));
            if (nNew == null) {
                nNew = "0";
            }
            String newPay = Bytes.toString(result.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSDAYTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSDAYTYPENUMBERTABLE[4])));
            if (newPay == null) {
                newPay = "0";
            }
            String newCrons = Bytes.toString(result.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSDAYTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSDAYTYPENUMBERTABLE[5])));
            if (newCrons == null) {
                newCrons = "0";
            }
            String tpn = Bytes.toString(result.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSDAYTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSDAYTYPENUMBERTABLE[6])));
            if (tpn == null) {
                tpn = "0";
            }
            String tcn = Bytes.toString(result.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSDAYTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSDAYTYPENUMBERTABLE[7])));
            if (tcn == null) {
                tcn = "0";
            }
            list.add(new Number(rowkey, active, nNew, activePay, activeCrons, newPay, newCrons, tpn, tcn));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 获取多天人数相关数据
     *
     * @param time1
     * @param time2
     * @return
     */
    public static List<Number> getManyDayNumber(String time1, String time2) {
        List<Number> list = new ArrayList<>();

        List<String> dateList = MyUtils.checkTime(time1, time2);
        try {
            for (String date : dateList) {
                Result r = JavaHBaseUtils.getRow(DataProcessProperties.USERSDAYTYPENUMBERTABLE, date);
                String active = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSDAYTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSDAYTYPENUMBERTABLE[0])));
                if (active == null) {
                    active = "0";
                }
                String activePay = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSDAYTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSDAYTYPENUMBERTABLE[1])));
                if (activePay == null) {
                    activePay = "0";
                }
                String activeCrons = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSDAYTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSDAYTYPENUMBERTABLE[2])));
                if (activeCrons == null) {
                    activeCrons = "0";
                }
                String nNew = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSDAYTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSDAYTYPENUMBERTABLE[3])));
                if (nNew == null) {
                    nNew = "0";
                }
                String newPay = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSDAYTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSDAYTYPENUMBERTABLE[4])));
                if (newPay == null) {
                    newPay = "0";
                }
                String newCrons = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSDAYTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSDAYTYPENUMBERTABLE[5])));
                if (newCrons == null) {
                    newCrons = "0";
                }
                String totalPay = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSDAYTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSDAYTYPENUMBERTABLE[6])));
                if (totalPay == null) {
                    totalPay = "0";
                }
                String totalCrons = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSDAYTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSDAYTYPENUMBERTABLE[7])));
                if (totalCrons == null) {
                    totalCrons = "0";
                }
                String row = date;
                list.add(new Number(row, active, activePay, activeCrons, nNew, newPay, newCrons, totalPay, totalCrons));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 获取一月人数相关数据
     *
     * @param time1
     * @return
     */
    public static List<Number> getMonthNumber(String time1) {
        List<Number> list = new ArrayList<>();
        try {
            Result result = JavaHBaseUtils.getRow(DataProcessProperties.USERSMONTHTYPENUMBERTABLE, time1);
            String rowkey = time1;
            String active = Bytes.toString(result.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSMONTHTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSMONTHTYPENUMBERTABLE[0])));
            if (active == null) {
                active = "0";
            }
            String activePay = Bytes.toString(result.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSMONTHTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSMONTHTYPENUMBERTABLE[1])));
            if (activePay == null) {
                activePay = "0";
            }
            String activeCrons = Bytes.toString(result.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSMONTHTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSMONTHTYPENUMBERTABLE[2])));
            if (activeCrons == null) {
                activeCrons = "0";
            }
            String nNew = Bytes.toString(result.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSMONTHTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSMONTHTYPENUMBERTABLE[3])));
            if (nNew == null) {
                nNew = "0";
            }
            String newPay = Bytes.toString(result.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSMONTHTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSMONTHTYPENUMBERTABLE[4])));
            if (newPay == null) {
                newPay = "0";
            }
            String newCrons = Bytes.toString(result.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSMONTHTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSMONTHTYPENUMBERTABLE[5])));
            if (newCrons == null) {
                newCrons = "0";
            }
            String tpn = Bytes.toString(result.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSMONTHTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSMONTHTYPENUMBERTABLE[6])));
            if (tpn == null) {
                tpn = "0";
            }
            String tcn = Bytes.toString(result.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSMONTHTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSMONTHTYPENUMBERTABLE[7])));
            if (tcn == null) {
                tcn = "0";
            }

            list.add(new Number(rowkey, active, nNew, activePay, activeCrons, newPay, newCrons, tpn, tcn));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 获取多月人数相关数据
     *
     * @param time1
     * @param time2
     * @return
     */
    public static List<Number> getManyMonthNumber(String time1, String time2) {
        List<Number> list = new ArrayList<>();
        ResultScanner rs = JavaHBaseUtils.getScanner(DataProcessProperties.USERSMONTHTYPENUMBERTABLE, time1, time2);
        for (Result r : rs) {
            String row = Bytes.toString(r.getRow());
            String active = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSMONTHTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSMONTHTYPENUMBERTABLE[0])));
            if (active == null) {
                active = "0";
            }
            String activePay = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSMONTHTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSMONTHTYPENUMBERTABLE[1])));
            if (activePay == null) {
                activePay = "0";
            }
            String activeCrons = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSMONTHTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSMONTHTYPENUMBERTABLE[2])));
            if (activeCrons == null) {
                activeCrons = "0";
            }
            String nNew = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSMONTHTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSMONTHTYPENUMBERTABLE[3])));
            if (nNew == null) {
                nNew = "0";
            }
            String newPay = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSMONTHTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSMONTHTYPENUMBERTABLE[4])));
            if (newPay == null) {
                newPay = "0";
            }
            String newCrons = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSMONTHTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSMONTHTYPENUMBERTABLE[5])));
            if (newCrons == null) {
                newCrons = "0";
            }
            String totalPay = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSMONTHTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSMONTHTYPENUMBERTABLE[6])));
            if (totalPay == null) {
                totalPay = "0";
            }
            String totalCrons = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSMONTHTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSMONTHTYPENUMBERTABLE[7])));
            if (totalCrons == null) {
                totalCrons = "0";
            }
            list.add(new Number(row, active, activePay, activeCrons, nNew, newPay, newCrons, totalPay, totalCrons));
        }
        try {
            Result r = JavaHBaseUtils.getRow(DataProcessProperties.USERSMONTHTYPENUMBERTABLE, time2);
            String active = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSMONTHTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSMONTHTYPENUMBERTABLE[0])));
            if (active == null) {
                active = "0";
            }
            String activePay = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSMONTHTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSMONTHTYPENUMBERTABLE[1])));
            if (activePay == null) {
                activePay = "0";
            }
            String activeCrons = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSMONTHTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSMONTHTYPENUMBERTABLE[2])));
            if (activeCrons == null) {
                activeCrons = "0";
            }
            String nNew = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSMONTHTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSMONTHTYPENUMBERTABLE[3])));
            if (nNew == null) {
                nNew = "0";
            }
            String newPay = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSMONTHTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSMONTHTYPENUMBERTABLE[4])));
            if (newPay == null) {
                newPay = "0";
            }
            String newCrons = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSMONTHTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSMONTHTYPENUMBERTABLE[5])));
            if (newCrons == null) {
                newCrons = "0";
            }
            String totalPay = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSMONTHTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSMONTHTYPENUMBERTABLE[6])));
            if (totalPay == null) {
                totalPay = "0";
            }
            String totalCrons = Bytes.toString(r.getValue(Bytes.toBytes(DataProcessProperties.cfsOfUSERSMONTHTYPENUMBERTABLE[0]), Bytes.toBytes(DataProcessProperties.columnsOfUSERSMONTHTYPENUMBERTABLE[7])));
            if (totalCrons == null) {
                totalCrons = "0";
            }
            String row = Bytes.toString(r.getRow());
            list.add(new Number(row, active, activePay, activeCrons, nNew, newPay, newCrons, totalPay, totalCrons));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
