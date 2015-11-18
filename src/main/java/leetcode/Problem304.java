package leetcode;

/**
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 */
public class Problem304 {
    public static class NumMatrix {
        private int[][] matrix;

        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;
            for (int row = 0; row < matrix.length; row++) {
                int[] nums = matrix[row];
                for (int col = 1; col < nums.length; col++) {
                    nums[col] = nums[col] + nums[col - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for (int row = row1; row <= row2; row++) {
                int[] nums = matrix[row];
                if (col1 - 1 >= 0) {
                    sum += nums[col2] - nums[col1 - 1];
                } else {
                    sum += nums[col2];
                }
            }
            return sum;
        }
    }
}
