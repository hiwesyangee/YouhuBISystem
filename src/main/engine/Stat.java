package engine;

/**
 * 统计相关数据对象
 */
public class Stat {
    private String times; // 具体天
    private String apr;  // 活跃充值率
    private String npr;  // 新增充值率
    private String aARPU; // 活跃ARPU
    private String aARPPU; // 活跃ARPPU
    private String nARPU; // 新增ARPU
    private String nARPPU; // 新增ARPPU
    private String appc; // 活跃人均充值
    private String apcc; // 活跃人均消费
    private String nppc; // 新增人均充值
    private String npcc; // 新增人均消费

    public Stat(String times, String apr, String npr, String aARPU, String aARPPU, String nARPU, String nARPPU, String appc, String apcc, String nppc, String npcc) {
        this.times = times;
        this.apr = apr;
        this.npr = npr;
        this.aARPU = aARPU;
        this.aARPPU = aARPPU;
        this.nARPU = nARPU;
        this.nARPPU = nARPPU;
        this.appc = appc;
        this.apcc = apcc;
        this.nppc = nppc;
        this.npcc = npcc;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getApr() {
        return apr;
    }

    public void setApr(String apr) {
        this.apr = apr;
    }

    public String getNpr() {
        return npr;
    }

    public void setNpr(String npr) {
        this.npr = npr;
    }

    public String getaARPU() {
        return aARPU;
    }

    public void setaARPU(String aARPU) {
        this.aARPU = aARPU;
    }

    public String getaARPPU() {
        return aARPPU;
    }

    public void setaARPPU(String aARPPU) {
        this.aARPPU = aARPPU;
    }

    public String getnARPU() {
        return nARPU;
    }

    public void setnARPU(String nARPU) {
        this.nARPU = nARPU;
    }

    public String getnARPPU() {
        return nARPPU;
    }

    public void setnARPPU(String nARPPU) {
        this.nARPPU = nARPPU;
    }

    public String getAppc() {
        return appc;
    }

    public void setAppc(String appc) {
        this.appc = appc;
    }

    public String getApcc() {
        return apcc;
    }

    public void setApcc(String apcc) {
        this.apcc = apcc;
    }

    public String getNppc() {
        return nppc;
    }

    public void setNppc(String nppc) {
        this.nppc = nppc;
    }

    public String getNpcc() {
        return npcc;
    }

    public void setNpcc(String npcc) {
        this.npcc = npcc;
    }
}
