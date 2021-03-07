package leetcode;

/**
 * https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/
 */
public class Problem1779 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int answer = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            if (point[0] == x) {
                int distance = manhattan(x, y, point[0], point[1]);
                if (distance < min) {
                    min = distance;
                    answer = i;
                }
            }
            if (point[1] == y) {
                int distance = manhattan(x, y, point[0], point[1]);
                if (distance < min) {
                    min = distance;
                    answer = i;
                }
            }
        }
        return answer;
    }

    private static int manhattan(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
