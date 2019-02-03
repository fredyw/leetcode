package leetcode;

/**
 * https://leetcode.com/problems/generate-random-point-in-a-circle/
 */
public class Problem478 {
    private static class Solution {
        private final double radius;
        private final double x;
        private final double y;

        public Solution(double radius, double x_center, double y_center) {
            this.radius = radius;
            this.x = x_center;
            this.y = y_center;
        }

        public double[] randPoint() {
            // https://en.wikipedia.org/wiki/Polar_coordinate_system
            double area = Math.random() * Math.PI * radius * radius;
            double r = Math.sqrt(area / Math.PI);
            double theta = Math.random() * 2 * Math.PI;
            return new double[]{Math.cos(theta) * r + x, Math.sin(theta) * r + y};
        }
    }
}
