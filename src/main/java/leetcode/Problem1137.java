package leetcode;

/**
 * https://leetcode.com/problems/n-th-tribonacci-number/
 */
public class Problem1137 {
    public int tribonacci(int n) {
        return tribonacci(n, new Integer[n + 1]);
    }

    private static int tribonacci(int n, Integer[] memo) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        if (memo[n] != null) {
            return memo[n];
        }
        int value = tribonacci(n - 1, memo) + tribonacci(n - 2, memo) + tribonacci(n - 3, memo);
        memo[n] = value;
        return value;
    }
}
