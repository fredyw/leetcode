package leetcode;

/**
 * https://leetcode.com/problems/magic-squares-in-grid/
 */
public class Problem840 {
    public int numMagicSquaresInside(int[][] grid) {
        int maxRow = grid.length;
        int maxCol = 0;
        if (grid.length > 0) {
            maxCol = grid[0].length;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (isMagicSquare(grid, maxRow, maxCol, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isMagicSquare(int[][] grid, int maxRow, int maxCol, int row, int col) {
        if (row + 2 >= maxRow || col + 2 >= maxCol) {
            return false;
        }
        boolean[] found = new boolean[10];
        // Check all rows and columns.
        int sumRow = 0;
        int sumCol = 0;
        for (int r1 = row, c2 = col; r1 < row + 3; r1++, c2++) {
            int tmpRow = 0;
            int tmpCol = 0;
            for (int c1 = col, r2 = row; c1 < col + 3; c1++, r2++) {
                int rowVal = grid[r1][c1];
                int colVal = grid[r2][c2];
                if (rowVal < 1 || rowVal > 9 || found[rowVal]) {
                    return false;
                }
                found[rowVal] = true;
                tmpRow += rowVal;
                tmpCol += colVal;
            }
            if (sumRow == 0) {
                sumRow = tmpRow;
            } else {
                if (sumRow != tmpRow) {
                    return false;
                }
            }
            if (sumCol == 0) {
                sumCol = tmpCol;
            } else {
                if (sumCol != tmpCol) {
                    return false;
                }
            }
        }
        // Check all diagonals.
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < 3; i++) {
            leftSum += grid[row + i][col + i];
            rightSum += grid[row + i][col + 2 - i];
        }
        if (leftSum != rightSum) {
            return false;
        }
        return true;
    }
}
