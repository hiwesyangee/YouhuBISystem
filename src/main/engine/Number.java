package engine;

/**
 * 人数相关数据对象
 */
public class Number {
    private String times;    // 时间
    private String active;    // 活跃用户数
    private String activePay;    // 活跃充值用户数
    private String activeCrons;    // 活跃消费用户数
    private String nNew;    // 新增用户数
    private String newPay;   // 新增充值用户数
    private String newCrons;    // 新增消费用户数
    private String tpn;    // 总充值用户数
    private String tcn;     // 总消费用户数

    public Number(String times, String active, String activePay, String activeCrons, String nNew, String newPay, String newCrons, String tpn, String tcn) {
        this.times = times;
        this.active = active;
        this.activePay = activePay;
        this.activeCrons = activeCrons;
        this.nNew = nNew;
        this.newPay = newPay;
        this.newCrons = newCrons;
        this.tpn = tpn;
        this.tcn = tcn;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getActivePay() {
        return activePay;
    }

    public void setActivePay(String activePay) {
        this.activePay = activePay;
    }

    public String getActiveCrons() {
        return activeCrons;
    }

    public void setActiveCrons(String activeCrons) {
        this.activeCrons = activeCrons;
    }

    public String getnNew() {
        return nNew;
    }

    public void setnNew(String nNew) {
        this.nNew = nNew;
    }

    public String getNewPay() {
        return newPay;
    }

    public void setNewPay(String newPay) {
        this.newPay = newPay;
    }

    public String getNewCrons() {
        return newCrons;
    }

    public void setNewCrons(String newCrons) {
        this.newCrons = newCrons;
    }

    public String getTpn() {
        return tpn;
    }

    public void setTpn(String tpn) {
        this.tpn = tpn;
    }

    public String getTcn() {
        return tcn;
    }

    public void setTcn(String tcn) {
        this.tcn = tcn;
    }

}
