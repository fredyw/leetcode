package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/maximum-population-year/
 */
public class Problem1854 {
    public int maximumPopulation(int[][] logs) {
        Arrays.sort(logs, (a, b) -> {
            int cmp = Integer.compare(a[0], b[0]);
            if (cmp == 0) {
                return Integer.compare(a[1], b[1]);
            }
            return cmp;
        });
        Map</* year */ Integer, /* count */ Integer> map = new HashMap<>();
        for (int i = 0; i < logs.length; i++) {
            int birth1 = logs[i][0];
            if (map.containsKey(birth1)) {
                map.put(birth1, map.getOrDefault(birth1, 0) + 1);
                continue;
            }
            map.put(birth1, 1);
            for (int j = i - 1; j >= 0; j--) {
                int death2 = logs[j][1];
                if (birth1 < death2) {
                    map.put(birth1, map.getOrDefault(birth1, 0) + 1);
                }
            }
        }
        return Collections.max(map.entrySet(), (a, b) -> {
            int cmp = Integer.compare(a.getValue(),b.getValue()); // by count
            if (cmp == 0) {
                return Integer.compare(b.getKey(), a.getKey()); // by year
            }
            return cmp;
        }).getKey();
    }
}
