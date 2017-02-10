package leetcode;

/**
 * https://leetcode.com/problems/diagonal-traverse/
 */
public class Problem498 {
    public int[] findDiagonalOrder(int[][] matrix) {
        int maxRow = matrix.length;
        if (maxRow == 0) {
            return new int[0];
        }
        int maxCol = matrix[0].length;
        int[] result = new int[maxRow * maxCol];
        boolean up = false;
        int idx = 0;
        int row = 0;
        int col = 0;
        result[idx++] = matrix[row][col];
        while (idx < maxRow * maxCol) {
            if (up) {
                if (row + 1 < maxRow) {
                    row++;
                } else {
                    col++;
                }
                while (0 <= row && row < maxRow && 0 <= col && col < maxCol) {
                    result[idx++] = matrix[row][col];
                    row--;
                    col++;
                }
                row++;
                col--;
            } else { // down
                if (col + 1 < maxCol) {
                    col++;
                } else {
                    row++;
                }
                while (0 <= row && row < maxRow && 0 <= col && col < maxCol) {
                    result[idx++] = matrix[row][col];
                    row++;
                    col--;
                }
                row--;
                col++;
            }
            up = !up;
        }
        return result;
    }
}
