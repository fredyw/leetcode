package leetcode;

/**
 * https://leetcode.com/problems/climbing-stairs/
 */
public class Problem70 {
    public int climbStairs(int n) {
        Integer[] memo = new Integer[n + 1];
        return climbStairs(n, memo);
    }

    private static int climbStairs(int n, Integer[] memo) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (memo[n] != null) {
            return memo[n];
        }
        int count = climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
        memo[n] = count;
        return count;
    }
}