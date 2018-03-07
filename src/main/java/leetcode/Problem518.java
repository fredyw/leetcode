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
//        Integer[][] memo = new Integer[amount + 1][coins.length];
//        return coinChange(amount, coins, 0, memo);
    }

    private static int coinChange(int amount, int[] coins, int idx, Integer[][] memo) {
        if (amount <= 0) {
            if (amount == 0) {
                return 1;
            }
            return 0;
        }
        if (memo[amount][idx] != null) {
            return memo[amount][idx];
        }
        int count = 0;
        for (int i = idx; i < coins.length; i++) {
            count += coinChange(amount - coins[i], coins, i, memo);
        }
        memo[amount][idx] = count;
        return count;
    }

    public static void main(String[] args) {
        Problem518 prob = new Problem518();
        System.out.println(prob.change(5, new int[]{1, 2, 5})); // 4
//        System.out.println(prob.change(3, new int[]{2})); // 0
//        System.out.println(prob.change(10, new int[]{10})); // 1
//        System.out.println(prob.change(5000, new int[]{1})); // 1
    }
}