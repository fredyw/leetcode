package leetcode;

/**
 * https://leetcode.com/problems/fibonacci-number/
 */
public class Problem509 {
    public int fib(int N) {
        return fib(N, new Integer[N + 1]);
    }

    private static int fib(int n, Integer[] memo) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (memo[n] != null) {
            return memo[n];
        }
        memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
        return memo[n];
    }
}
