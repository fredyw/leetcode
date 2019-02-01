package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/generate-random-point-in-a-circle/
 */
public class Problem478 {
    private static class Solution {
        public Solution(double radius, double x_center, double y_center) {
            // TODO
        }

        public double[] randPoint() {
            // TODO
            return null;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution(1, 0, 0);
        System.out.println(Arrays.toString(solution.randPoint())); // [-0.72939,-0.65505]
        System.out.println(Arrays.toString(solution.randPoint())); // [-0.78502,-0.28626]
        System.out.println(Arrays.toString(solution.randPoint())); // [-0.83119,-0.19803]

        solution = new Solution(10, 5, -7.5);
        System.out.println(Arrays.toString(solution.randPoint())); // [11.52438,-8.33273]
        System.out.println(Arrays.toString(solution.randPoint())); // [2.46992,-16.21705]
        System.out.println(Arrays.toString(solution.randPoint())); // [11.13430,-12.42337]
    }
}
