package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/
 */
public class Problem1637 {
    public int maxWidthOfVerticalArea(int[][] points) {
        int[] x = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            x[i] = points[i][0];
        }
        Arrays.sort(x);
        int answer = 0;
        for (int i = 0; i < x.length - 1; i++) {
            answer = Math.max(answer, x[i + 1] - x[i]);
        }
        return answer;
    }
}
