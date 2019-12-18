package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/remove-covered-intervals/
 */
public class Problem1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        Set<Integer> removed = new HashSet<>();
        for (int i = 0; i < intervals.length; i++) {
            if (removed.contains(i)) {
                continue;
            }
            for (int j = i + 1; j < intervals.length; j++) {
                if (removed.contains(j)) {
                    continue;
                }
                int a = intervals[i][0];
                int b = intervals[i][1];
                int c = intervals[j][0];
                int d = intervals[j][1];
                if (c <= a && b <= d) {
                    removed.add(i);
                } else if (a <= c && d <= b) {
                    removed.add(j);
                }
            }
        }
        return intervals.length - removed.size();
    }
}
