package leetcode;

/**
 * https://leetcode.com/problems/minimum-time-visiting-all-points/
 */
public class Problem1266 {
    public int minTimeToVisitAllPoints(int[][] points) {
        int answer = 0;
        for (int i = 0; i < points.length - 1; i++) {
            answer += chebyshev(points[i], points[i + 1]);
        }
        return answer;
    }

    private static int chebyshev(int[] point1, int[] point2) {
        // https://en.wikipedia.org/wiki/Chebyshev_distance
        return Math.max(Math.abs(point1[0] - point2[0]), Math.abs(point1[1] - point2[1]));
    }
}
