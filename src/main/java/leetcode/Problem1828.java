package leetcode;

/**
 * https://leetcode.com/problems/queries-on-number-of-points-inside-a-circle/
 */
public class Problem1828 {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < points.length; j++) {
                int x1 = queries[i][0];
                int y1 = queries[i][1];
                int r = queries[i][2];
                int x2 = points[j][0];
                int y2 = points[j][1];
                if (withinCircle(x1, x2, y1, y2, r)) {
                    answer[i]++;
                }
            }
        }
        return answer;
    }

    private static boolean withinCircle(int x1, int x2, int y1, int y2, int radius) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)) <= radius;
    }
}
