package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/unique-paths-ii/
 */
public class Problem63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) {
            return 0;
        }
        Map<String, Integer> memo = new HashMap<>();
        return findPaths(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1,
            0, 0, memo);
    }

    private int findPaths(int[][] grid, int destRow, int destCol, int row, int col,
                          Map<String, Integer> memo) {
        if (row > destRow || col > destCol) {
            return 0;
        }
        if (grid[row][col] == 1) {
            return 0;
        }
        if (row == destRow && col == destCol) {
            return 1;
        }
        String key = row + "|" + col;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int a = findPaths(grid, destRow, destCol, row + 1, col, memo);
        int b = findPaths(grid, destRow, destCol, row, col + 1, memo);
        int result = a + b;
        memo.put(key, result);
        return result;
    }
}
