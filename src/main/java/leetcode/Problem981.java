package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/time-based-key-value-store/
 */
public class Problem981 {
    private static final Map<String, TreeSet<ValueTimestamp>> map = new HashMap<>();

    private static class TimeMap {
        public TimeMap() {
        }

        public void set(String key, String value, int timestamp) {
            if (!map.containsKey(key)) {
                TreeSet<ValueTimestamp> set = new TreeSet<>(Comparator.comparingInt(a -> a.timestamp));
                set.add(new ValueTimestamp(value, timestamp));
                map.put(key, set);
            } else {
                map.get(key).add(new ValueTimestamp(value, timestamp));
            }
        }

        public String get(String key, int timestamp) {
            TreeSet<ValueTimestamp> set = map.get(key);
            if (set == null) {
                return "";
            }
            ValueTimestamp value = set.floor(new ValueTimestamp("", timestamp));
            if (value == null) {
                return "";
            }
            return value.value;
        }
    }

    private static class ValueTimestamp {
        private final String value;
        private final int timestamp;


        public ValueTimestamp(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}
