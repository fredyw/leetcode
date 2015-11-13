package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 */
public class Problem304 {
    public static class NumMatrix {
        private final Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        private int[][] matrix;

        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;
            for (int row = 0; row < matrix.length; row++) {
                int[] nums = matrix[row];
                int sum = nums[0];
                Map<Integer, Integer> numMap = new HashMap<>();
                for (int col = 1; col < nums.length; col++) {
                    sum += nums[col];
                    numMap.put(col, sum);
                    map.put(row, numMap);
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for (int row = row1; row <= row2; row++) {
                int[] nums = matrix[row];
                if (col1 == col2) {
                    return nums[col1];
                }
                Integer a = map.get(row).get(col1);
                if (a == null) {
                    a = 0;
                }
                if (col1 > 0) {
                    a -= nums[col1];
                }
                Integer b = map.get(row).get(col2);
                if (b == null) {
                    b = 0;
                }
                sum += b - a;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        NumMatrix matrix = new NumMatrix(new int[][]{
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5},
        });
        System.out.println(matrix.sumRegion(2, 1, 4, 3)); // 8
        System.out.println(matrix.sumRegion(1, 1, 2, 2)); // 11
        System.out.println(matrix.sumRegion(1, 2, 2, 4)); // 12
    }
}
