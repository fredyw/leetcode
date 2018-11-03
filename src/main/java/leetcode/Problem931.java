package leetcode;

/**
 * https://leetcode.com/problems/minimum-falling-path-sum/
 */
public class Problem931 {
    public int minFallingPathSum(int[][] A) {
        int maxRow = A.length;
        int maxCol = A.length > 0 ? A[0].length : 0;
        int min = Integer.MAX_VALUE;
        Integer[][] memo = new Integer[maxRow + 1][maxCol + 1];
        for (int col = 0; col < maxCol; col++) {
            min = Math.min(min, minFaillingPathSum(A, maxRow, maxCol, 0, col, memo));
        }
        return min;
    }

    private static int minFaillingPathSum(int[][] a, int maxRow, int maxCol, int row, int col,
                                          Integer[][] memo) {
        if (row < 0 || col < 0 || row >= maxRow || col >= maxCol) {
            if (row < maxRow) {
                return Integer.MAX_VALUE;
            }
            return 0;
        }
        if (memo[row][col] != null) {
            return memo[row][col];
        }
        int value = a[row][col];
        int min = Integer.MAX_VALUE;
        min = Math.min(min, minFaillingPathSum(a, maxRow, maxCol, row + 1, col - 1, memo));
        min = Math.min(min, minFaillingPathSum(a, maxRow, maxCol, row + 1, col, memo));
        min = Math.min(min, minFaillingPathSum(a, maxRow, maxCol, row + 1, col + 1, memo));
        min += value;
        memo[row][col] = min;
        return min;
    }
}
