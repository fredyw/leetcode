package leetcode;

/**
 * https://leetcode.com/problems/integer-break/
 */
public class Problem343 {
    public int integerBreak(int n) {
        Integer[] memo = new Integer[n + 1];
        return integerBreak(n, memo);
    }

    private static int integerBreak(int n, Integer[] memo) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (memo[n] != null) {
            return memo[n];
        }
        int max = 0;
        for (int i = 1; i < n; i++) {
            int x1 = n - i;
            int y1 = n - x1;
            int x2 = integerBreak(x1, memo);
            int x = Math.max(x1, x2);
            int y2 = integerBreak(y1, memo);
            int y = Math.max(y1, y2);
            max = Math.max(x * y, max);
        }
        memo[n] = max;
        return max;
    }
}
