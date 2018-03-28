package leetcode;

/**
 * https://leetcode.com/problems/max-increase-to-keep-city-skyline/
 */
public class Problem807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int nRow = grid.length;
        int nCol = 0;
        if (grid.length > 0) {
            nCol = grid[0].length;
        }
        int[] maxRows = new int[nRow];
        int[] maxCols = new int[nCol];

        for (int row = 0; row < nRow; row++) {
            for (int col = 0; col < nCol; col++) {
                maxRows[row] = Math.max(maxRows[row], grid[row][col]);
                maxCols[col] = Math.max(maxCols[col], grid[row][col]);
            }
        }

        int result = 0;
        for (int row = 0; row < nRow; row++) {
            for (int col = 0; col < nCol; col++) {
                int max = Math.max(maxRows[row], maxCols[col]);
                int min = Math.min(maxRows[row], maxCols[col]);
                if (grid[row][col] < max) {
                    result += min - grid[row][col];
                }
            }
        }
        return result;
    }
}
