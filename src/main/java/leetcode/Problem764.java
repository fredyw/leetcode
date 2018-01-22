package leetcode;

/**
 * https://leetcode.com/problems/largest-plus-sign/
 */
public class Problem764 {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int result = 0;
        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = 1;
            }
        }
        for (int i = 0; i < mines.length; i++) {
            int[] mine = mines[i];
            int x = mine[0];
            int y = mine[1];
            grid[x][y] = 0;
        }
        int[][] dp = new int[N][N];
        for (int row = 0; row < N; row++) {
            int count = 0;
            for (int col = 0; col < N; col++) {
                if (grid[row][col] == 1) {
                    count++;
                } else {
                    count = 0;
                }
                dp[row][col] = count;
            }
            count = 0;
            for (int col = N - 1; col >= 0; col--) {
                if (grid[row][col] == 1) {
                    count++;
                } else {
                    count = 0;
                }
                dp[row][col] = Math.min(dp[row][col], count);
            }
        }

        for (int col = 0; col < N; col++) {
            int count = 0;
            for (int row = 0; row < N; row++) {
                if (grid[row][col] == 1) {
                    count++;
                } else {
                    count = 0;
                }
                dp[row][col] = Math.min(dp[row][col], count);
            }
            count = 0;
            for (int row = N - 1; row >= 0; row--) {
                if (grid[row][col] == 1) {
                    count++;
                } else {
                    count = 0;
                }
                dp[row][col] = Math.min(dp[row][col], count);
                result = Math.max(result, dp[row][col]);
            }
        }
        return result;
    }
}
