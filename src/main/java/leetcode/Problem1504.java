package leetcode;

/**
 * https://leetcode.com/problems/count-submatrices-with-all-ones/
 */
public class Problem1504 {
    public int numSubmat(int[][] mat) {
        int maxRow = mat.length;
        int maxCol = maxRow > 0 ? mat[0].length : 0;
        int[][] dp = new int[maxRow][maxCol];
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                if (col == 0) {
                    dp[row][col] = mat[row][col];
                } else {
                    if (mat[row][col] == 0) {
                        dp[row][col] = 0;
                    } else {
                        dp[row][col] = dp[row][col - 1] + 1;
                    }
                }
            }
        }
        int answer = 0;
        for (int row = 0; row < maxRow; row++) { // top to down
            for (int col = 0; col < maxCol; col++) { // left to right
                if (mat[row][col] == 0) {
                    continue;
                }
                int min = Integer.MAX_VALUE;
                for (int r = row; r >= 0 && mat[r][col] == 1; r--) { // r to top
                    min = Math.min(min, dp[r][col]);
                    answer += min;
                }
            }
        }
        return answer;
    }
}
