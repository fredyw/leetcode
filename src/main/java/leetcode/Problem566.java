package leetcode;

/**
 * https://leetcode.com/problems/reshape-the-matrix/
 */
public class Problem566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int rowSize = nums.length;
        int colSize = 0;
        if (rowSize > 0) {
            colSize = nums[0].length;
        }
        if (r * c > rowSize * colSize) {
            return nums;
        }
        int row = 0;
        int col = 0;
        int[][] result = new int[r][c];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (col == c) {
                    col = 0;
                    row++;
                }
                result[row][col] = nums[i][j];
                col++;
            }
        }
        return result;
    }
}
