package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 */
public class Problem452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> {
            int comp = Integer.compare(a[0], b[0]);
            if (comp == 0) {
                return Integer.compare(a[1], b[1]);
            }
            return comp;
        });
        int start1 = points[0][0];
        int end1 = points[0][1];
        int result = 1;
        for (int i = 1; i < points.length; i++) {
            int start2 = points[i][0];
            int end2 = points[i][1];
            if (start1 <= start2 && start2 <= end1) {
                start1 = Math.max(start1, start2);
                end1 = Math.min(end1, end2);
            } else {
                result++;
                start1 = start2;
                end1 = end2;
            }
        }
        return result;
    }
}
