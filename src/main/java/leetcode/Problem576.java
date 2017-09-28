package leetcode;

/**
 * https://leetcode.com/problems/out-of-boundary-paths/
 */
public class Problem576 {
    public int findPaths(int m, int n, int N, int i, int j) {
        int[][] grid = new int[m][n];
        Long[][][] memo = new Long[m][n][N + 1];
        return (int) findPaths(grid, m, n, i, j, N, memo);
    }

    private static long findPaths(int[][] grid, int maxRow, int maxCol, int row, int col, int n,
                                  Long[][][] memo) {
        if (row < 0 || row >= maxRow || col < 0 || col >= maxCol) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        if (memo[row][col][n] != null) {
            return memo[row][col][n];
        }
        // up
        long a = findPaths(grid, maxRow, maxCol, row - 1, col, n - 1, memo) % (1000000000 + 7);
        // right
        long b = findPaths(grid, maxRow, maxCol, row, col + 1, n - 1, memo) % (1000000000 + 7);
        // down
        long c = findPaths(grid, maxRow, maxCol, row + 1, col, n - 1, memo) % (1000000000 + 7);
        // left
        long d = findPaths(grid, maxRow, maxCol, row, col - 1, n - 1, memo) % (1000000000 + 7);
        long total = (a + b + c + d) % (1000000000 + 7);
        memo[row][col][n] = total;
        return total;
    }
}
