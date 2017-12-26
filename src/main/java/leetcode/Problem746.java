package leetcode;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 */
public class Problem746 {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 2];
        for (int i = cost.length - 1; i >= 0; i--) {
            dp[i] = Math.min(dp[i + 1], dp[i + 2]) + cost[i];
        }
        return Math.min(dp[0], dp[1]);
    }

//    public int minCostClimbingStairs(int[] cost) {
//        Integer[] memo = new Integer[cost.length];
//        return Math.min(minCostClimbingStairs(cost, 0, memo), minCostClimbingStairs(cost, 1, memo));
//    }
//
//    private static int minCostClimbingStairs(int[] cost, int idx, Integer[] memo) {
//        if (idx >= cost.length) {
//            return 0;
//        }
//        if (memo[idx] != null) {
//            return memo[idx];
//        }
//        int a = minCostClimbingStairs(cost, idx + 1, memo);
//        int b = minCostClimbingStairs(cost, idx + 2, memo);
//        int min = Math.min(a, b) + cost[idx];
//        memo[idx] = min;
//        return min;
//    }
}
