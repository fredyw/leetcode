package leetcode;

/**
 * https://leetcode.com/problems/coin-change-2/
 */
public class Problem518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                int diff = j - coins[i];
                if (diff >= 0) {
                    dp[j] += dp[diff];
                }
            }
        }
        return dp[amount];
    }
}