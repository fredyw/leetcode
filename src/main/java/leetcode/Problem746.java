package leetcode;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 */
public class Problem746 {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        int min = 0;
        for (int i = cost.length - 1; i >= 0; i--) {
            int a = 0;
            if (i - 2 >= 0) {
                a = dp[i - 2];
            }
            int b = dp[i - 1];
            dp[i] = cost[i] + Math.min(a, b);
        }
        return min;
    }

    public static void main(String[] args) {
        Problem746 prob = new Problem746();
        System.out.println(prob.minCostClimbingStairs(new int[]{10, 15, 20})); // 15
        System.out.println(prob.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1})); // 6
    }
}
