package leetcode;

/**
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 */
public class Problem304 {
    public static class NumMatrix {

        public NumMatrix(int[][] matrix) {

        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            // TODO:
            return 0;
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
