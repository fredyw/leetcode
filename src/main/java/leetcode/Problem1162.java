package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/as-far-from-land-as-possible/
 */
public class Problem1162 {
    public int maxDistance(int[][] grid) {
        List<int[]> waters = new ArrayList<>();
        List<int[]> lands = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    waters.add(new int[]{i, j});
                } else {
                    lands.add(new int[]{i, j});
                }
            }
        }
        int answer = Integer.MIN_VALUE;
        for (int[] water : waters) {
            int min = Integer.MAX_VALUE;
            for (int[] land : lands) {
                min = Math.min(min, getDistance(water, land));
            }
            answer = Math.max(answer, min == Integer.MAX_VALUE ? -1 : min);
        }
        return answer == Integer.MIN_VALUE ? -1 : answer;
    }

    private static int getDistance(int[] x, int[] y) {
        return Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]);
    }
}
