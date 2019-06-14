package engine;

import java.util.Map;

/**
 * 排行相关数据对象
 */
public class PayRank {
    private String times;
    private Map<String, String> userPay;

    public PayRank(String times, Map<String, String> userPay) {
        this.times = times;
        this.userPay = userPay;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public Map<String, String> getUserPay() {
        return userPay;
    }

    public void setUserPay(Map<String, String> userPay) {
        this.userPay = userPay;
    }
}
