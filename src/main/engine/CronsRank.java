package engine;

import java.util.Map;

public class CronsRank {
    private String times;
    private Map<String, String> userCrons;

    public CronsRank(String times, Map<String, String> userCrons) {
        this.times = times;
        this.userCrons = userCrons;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public Map<String, String> getUserCrons() {
        return userCrons;
    }

    public void setUserCrons(Map<String, String> userCrons) {
        this.userCrons = userCrons;
    }
}
