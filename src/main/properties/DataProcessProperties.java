package properties;

public class DataProcessProperties {
    // 1.用户充值/消费表——————————————rowkey:20181016154820_uid
    public final static String USERSPAYCRONSTABLE = "users_pay_crons_data";
    public final static String[] cfsOfUSERSPAYCRONSTABLE = {"info"};
    public final static String[] columnsOfUSERSPAYCRONSTABLE = {"pay", "payType", "crons", "cronsType"}; // 充值金额，充值方式，消费金额，消费方式

    // 2.每日充值/消费用户列表——————————————rowkey:20181016
    public final static String DAYPAYCRONSTABLE = "day_pay_crons_data";
    public final static String[] cfsOfDAYPAYCRONSTABLE = {"info"};
    public final static String[] columnsOfDAYPAYCRONSTABLE = {"aPay", "aCrons", "nPay", "nCrons"}; // 活跃充值用户，活跃消费用户，新增充值用户，新增用户消费

    // 3.每日活跃/新增人数表——————————————rowkey:20181016
    public final static String USERSDAYTYPENUMBERTABLE = "users_day_type_number_data";
    public final static String[] cfsOfUSERSDAYTYPENUMBERTABLE = {"info"};
    public final static String[] columnsOfUSERSDAYTYPENUMBERTABLE = {"active", "activePay", "activeCrons", "nNew", "newPay", "newCrons", "tpn", "tcn"}; // 活跃用户数，活跃充值用户数，活跃消费用户数，新增用户数，新增充值用户数，新增消费用户数，总充值人数，总消费人数

    // 4.日度表——————————————rowkey:20181016
    public final static String USERSACTIONDAYSTATTABLE = "users_action_day_stat"; // 每日统计表
    public final static String[] cfsOfUSERSACTIONDAYSTATTABLE = {"info"};
    public final static String[] columnsOfUSERSACTIONDAYSTATTABLE = {"tpm", "tcm", "apm", "acm", "npm", "ncm", "apr", "npr", "aARPU", "aARPPU", "nARPU", "nARPPU", "appc", "apcc", "nppc", "npcc"}; // 总充值额，总消费额，活跃充值额，活跃消费额，新增充值额，新增消费额，实时活跃付费率、实时新增付费率、实时活跃ARPU、实时新增ARPU、实时活跃ARPPU、实时新增ARPPU、实时活跃人均充值，实时活跃人均消费，实时新增人均充值，实时新增人均消费

    // 5.每日用户充值消费额表——————————————rowkey:20181016_uid
    public final static String USERSPAYCRONSDAYAMOUNTTABLE = "users_paycrons_day_amount"; // 每日用户充值消费额
    public final static String[] cfsOfUSERSPAYCRONSDAYAMOUNTTABLE = {"info"};
    public final static String[] columnsOfUSERSPAYCRONSDAYAMOUNTTABLE = {"pay", "crons"}; // 充值额，消费额

    // 6.每月活跃/新增人数表——————————————rowkey:201810
    public final static String USERSMONTHTYPENUMBERTABLE = "users_month_type_number_data";
    public final static String[] cfsOfUSERSMONTHTYPENUMBERTABLE = {"info"};
    public final static String[] columnsOfUSERSMONTHTYPENUMBERTABLE = {"active", "activePay", "activeCrons", "nNew", "newPay", "newCrons", "tpn", "tcn"}; // 活跃用户数，活跃充值用户数，活跃消费用户数，新增用户数，新增充值用户数，新增消费用户数，总充值人数，总消费人数

    // 7.月度表——————————————rowkey:201810
    public final static String USERSACTIONMONTHSTATTABLE = "users_action_month_stat"; // 每月统计表
    public final static String[] cfsOfUSERSACTIONMONTHSTATTABLE = {"info"};
    public final static String[] columnsOfUSERSACTIONMONTHSTATTABLE = {"tpm", "tcm", "apm", "acm", "npm", "ncm", "apr", "npr", "aARPU", "aARPPU", "nARPU", "nARPPU", "appc", "apcc", "nppc", "npcc"}; // 总充值额，总充值人数，总消费额，总消费人数，实时活跃付费率、实时新增付费率、实时活跃ARPU、实时新增ARPU、实时活跃ARPPU、实时新增ARPPU、实时活跃人均消费，实时新增人均消费

    // 8.每月用户充值消费额表——————————————rowkey:201810_uid
    public final static String USERSPAYCRONSMONTHAMOUNTTABLE = "users_paycrons_month_amount"; // 每月用户充值消费额
    public final static String[] cfsOfUSERSPAYCRONSMONTHAMOUNTTABLE = {"info"};
    public final static String[] columnsOfUSERSPAYCRONSMONTHAMOUNTTABLE = {"pay", "crons"}; // 充值额，消费额

}
