package leetcode;

/**
 * https://leetcode.com/problems/uncrossed-lines/
 */
public class Problem1035 {
    public int maxUncrossedLines(int[] A, int[] B) {
        Integer[][] memo = new Integer[A.length][B.length];
        return maxUncrossedLines(A, B, 0, 0, memo);
    }

    private static int maxUncrossedLines(int[] a, int[] b, int i, int j, Integer[][] memo) {
        if (i == a.length || j == b.length) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        int max = 0;
        for (int x = i; x < a.length; x++) {
            if (a[x] == b[j]) {
                max = Math.max(max, maxUncrossedLines(a, b, x + 1, j + 1, memo) + 1);
            }
            max = Math.max(max, maxUncrossedLines(a, b, x, j + 1, memo));
        }
        memo[i][j] = max;
        return max;
    }
}
