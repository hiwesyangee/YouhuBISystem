package engine;

/**
 * 金额相关数据对象
 */
public class Amount {
    private String times; // 时间
    private String tpm;  // 总充值额
    private String tcm;  // 总消费额
    private String apm;  // 活跃充值额
    private String acm;  // 活跃消费额
    private String npm;  // 新增充值额
    private String ncm;  // 新增消费额

    public Amount(String times, String tpm, String tcm, String apm, String acm, String npm, String ncm) {
        this.times = times;
        this.tpm = tpm;
        this.tcm = tcm;
        this.apm = apm;
        this.acm = acm;
        this.npm = npm;
        this.ncm = ncm;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getTpm() {
        return tpm;
    }

    public void setTpm(String tpm) {
        this.tpm = tpm;
    }

    public String getTcm() {
        return tcm;
    }

    public void setTcm(String tcm) {
        this.tcm = tcm;
    }

    public String getApm() {
        return apm;
    }

    public void setApm(String apm) {
        this.apm = apm;
    }

    public String getAcm() {
        return acm;
    }

    public void setAcm(String acm) {
        this.acm = acm;
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }
}
