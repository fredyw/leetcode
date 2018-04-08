package leetcode;

/**
 * https://leetcode.com/problems/largest-triangle-area/
 */
public class Problem812 {
    public double largestTriangleArea(int[][] points) {
        // https://en.wikipedia.org/wiki/Heron%27s_formula
        double maxArea = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 0; k < points.length; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    double a = distance(points[i], points[j]);
                    double b = distance(points[i], points[k]);
                    double c = distance(points[j], points[k]);
                    double s = (a + b + c) / 2;
                    double area = Math.sqrt(s * Math.abs(s - a) * Math.abs(s - b) * Math.abs(s - c));
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private static double distance(int[] x, int[] y) {
        return Math.sqrt(Math.pow(x[0] - y[0], 2) + Math.pow(x[1] - y[1], 2));
    }
}
