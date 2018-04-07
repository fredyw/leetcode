package leetcode;

/**
 * https://leetcode.com/problems/unique-paths/
 */
public class Problem62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 || j == n - 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
    }

//    public int uniquePaths(int m, int n) {
//        Integer[][] memo = new Integer[m + 1][n + 1];
//        return uniquePaths(m, n, 1, 1, memo);
//    }
//
//    private int uniquePaths(int m, int n, int x, int y, Integer[][] memo) {
//        if (x > m || y > n) {
//            return 0;
//        }
//        if (x == m && y == n) {
//            return 1;
//        }
//        if (memo[x][y] != null) {
//            return memo[x][y];
//        }
//        int a = uniquePaths(m, n, x + 1, y, memo);
//        int b = uniquePaths(m, n, x, y + 1, memo);
//        int result = a + b;
//        memo[x][y] = result;
//        return result;
//    }
}
