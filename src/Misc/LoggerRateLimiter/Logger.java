package Misc.LoggerRateLimiter;

import java.util.HashMap;
import java.util.Map;

public class Logger {
    Map<String, Integer> logs;

    public Logger() {
        logs = new HashMap<String, Integer>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!this.logs.containsKey(message)) {
            this.logs.put(message, timestamp);
            return true;
        }
        int oldTimeStamp = this.logs.get(message);

        if(timestamp - oldTimeStamp >= 10) {
            this.logs.put(message, timestamp);
            return true;
        } else {
            return false;
        }
    }
}