package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/design-log-storage-system/
 */
public class Problem639 {
    public static class LogSystem {

        public LogSystem() {
            // TODO
        }

        public void put(int id, String timestamp) {
            // TODO
        }

        public List<Integer> retrieve(String s, String e, String gra) {
            // TODO
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        LogSystem log = new LogSystem();
        log.put(1, "2017:01:01:23:59:59");
        log.put(2, "2017:01:01:22:59:59");
        log.put(3, "2016:01:01:00:00:00");
        log.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year"); // return [1,2,3], because you need to return all logs within 2016 and 2017.
        log.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Hour"); // return [1,2], because you need to return all logs start from 2016:01:01:01 to 2017:01:01:23, where log 3 is left outside the range.
    }
}
