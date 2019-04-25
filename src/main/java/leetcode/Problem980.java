package leetcode;

/**
 * https://leetcode.com/problems/unique-paths-iii/
 */
public class Problem980 {
    public int uniquePathsIII(int[][] grid) {
        int maxRow = grid.length;
        int maxCol = maxRow > 0 ? grid[0].length : 0;
        int row = 0;
        int col = 0;
        int steps = 0;
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                if (grid[i][j] == -1) {
                    continue;
                }
                steps++;
                if (grid[i][j] == 1) {
                    row = i;
                    col = j;
                }
            }
        }
        return uniquePaths(grid, maxRow, maxCol, row, col, steps - 1);
    }

    private static int uniquePaths(int[][] grid, int maxRow, int maxCol, int row, int col,
                                   int steps) {
        if (row < 0 || row == maxRow || col < 0 || col == maxCol) {
            return 0;
        }
        if (grid[row][col] == -1) {
            return 0;
        }
        if (grid[row][col] == 2) {
            return steps == 0 ? 1 : 0;
        }
        grid[row][col] = -1;
        int a = uniquePaths(grid, maxRow, maxCol, row - 1, col, steps - 1); // up
        int b = uniquePaths(grid, maxRow, maxCol, row, col + 1, steps - 1); // right
        int c = uniquePaths(grid, maxRow, maxCol, row + 1, col, steps - 1); // down
        int d = uniquePaths(grid, maxRow, maxCol, row, col - 1, steps - 1); // left
        grid[row][col] = 0; // backtrack
        return a + b + c + d;
    }
}
