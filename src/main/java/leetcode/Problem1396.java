package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/design-underground-system/
 */
public class Problem1396 {
    static class UndergroundSystem {
        private static class StationTime {
            private final String station;
            private final int time;

            public StationTime(String station, int time) {
                this.station = station;
                this.time = time;
            }
        }

        private static class SumCount {
            private int sum;
            private int count;
        }

        private final Map<Integer, StationTime> checkIns = new HashMap<>();
        private final Map<String, SumCount> checkOuts = new HashMap<>();

        public UndergroundSystem() {
        }

        public void checkIn(int id, String stationName, int t) {
            checkIns.put(id, new StationTime(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            StationTime from = checkIns.get(id);
            String key = key(from.station, stationName);
            if (!checkOuts.containsKey(key)) {
                checkOuts.put(key, new SumCount());
            }
            SumCount sumCount = checkOuts.get(key);
            sumCount.sum += t - from.time;
            sumCount.count++;
            checkIns.remove(id);
        }

        public double getAverageTime(String startStation, String endStation) {
            SumCount sumCount = checkOuts.get(key(startStation, endStation));
            return sumCount.sum / (double) sumCount.count;
        }

        private static String key(String station1, String station2) {
            return station1 + "|" + station2;
        }
    }
}
