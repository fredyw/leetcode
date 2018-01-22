package leetcode;

/**
 * https://leetcode.com/problems/toeplitz-matrix/
 */
public class Problem766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = 0;
        if (matrix.length > 0) {
            numCols = matrix[0].length;
        }
        boolean same = isSameDiagonal(matrix, 0, 0, numRows, numCols);
        if (!same) {
            return false;
        }
        for (int col = 1; col < numCols; col++) {
            if (!isSameDiagonal(matrix, 0, col, numRows, numCols)) {
                return false;
            }
        }
        for (int row = 1; row < numRows; row++) {
            if (!isSameDiagonal(matrix, row, 0, numRows, numCols)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSameDiagonal(int[][] matrix, int row, int col, int numRows, int numCols) {
        int a = -1;
        for (int r = row, c = col; r < numRows && c < numCols; r++, c++) {
            if (a == -1) {
                a = matrix[r][c];
            } else {
                if (matrix[r][c] != a) {
                    return false;
                }
            }
        }
        return true;
    }
}
