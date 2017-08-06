package leetcode;

/**
 * https://leetcode.com/problems/2-keys-keyboard/
 */
public class Problem650 {
    public int minSteps(int n) {
        Integer[][] memo = new Integer[n][n];
        return minSteps(1, n, 1, memo);
    }

    private static int minSteps(int m, int n, int x, Integer[][] memo) {
        if (n == 1) {
            return 0;
        }
        if (m == n) {
            return 1;
        }
        if (m > n) {
            return Integer.MAX_VALUE;
        }
        if (memo[m][x] != null) {
            return memo[m][x];
        }
        int a = minSteps(m + x, n, x, memo);
        if (a < Integer.MAX_VALUE) {
            a++;
        }
        int b = minSteps(m + m, n, m, memo);
        if (b < Integer.MAX_VALUE) {
            // copy all + paste
            b += 2;
        }
        int min = Math.min(a, b);
        memo[m][x] = min;
        return min;
    }
}
