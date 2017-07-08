package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/design-log-storage-system/
 */
public class Problem639 {
    public static class LogSystem {
        private final List<String[]> timestamps = new ArrayList<>();
        private final Map<String, Integer> idxMap = new HashMap<>();

        public LogSystem() {
            idxMap.put("Year", 4);
            idxMap.put("Month", 7);
            idxMap.put("Day", 10);
            idxMap.put("Hour", 13);
            idxMap.put("Minute", 16);
            idxMap.put("Second", 19);
        }

        public void put(int id, String timestamp) {
            String[] array = new String[]{Integer.toString(id), timestamp};
            timestamps.add(array);
        }

        public List<Integer> retrieve(String s, String e, String gra) {
            List<Integer> result = new ArrayList<>();
            for (String[] timestamp : timestamps) {
                String substring = timestamp[1].substring(0, idxMap.get(gra));
                int cmp1 = substring.compareTo(s.substring(0, idxMap.get(gra)));
                int cmp2 = substring.compareTo(e.substring(0, idxMap.get(gra)));
                if (cmp1 >= 0 && cmp2 <= 0) {
                    result.add(Integer.valueOf(timestamp[0]));
                }
            }
            return result;
        }
    }
}
