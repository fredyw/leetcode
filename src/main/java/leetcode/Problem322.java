package leetcode;

/**
 * https://leetcode.com/problems/coin-change/
 */
public class Problem322 {
    public int coinChange(int[] coins, int amount) {
        Integer[] memo = new Integer[amount + 1];
        int result = coinChange(coins, amount, memo);
        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        return result - 1;
    }

    private static int coinChange(int[] coins, int amount, Integer[] memo) {
        if (amount < 0) {
            return Integer.MAX_VALUE;
        } else if (amount == 0) {
            return 1;
        }
        if (memo[amount] != null) {
            return memo[amount];
        }
        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            int tmp = coinChange(coins, amount - coin, memo);
            if (tmp != Integer.MAX_VALUE) {
                result = Math.min(result, tmp);
            }
        }
        if (result != Integer.MAX_VALUE) {
            result++;
        }
        memo[amount] = result;
        return result;
    }
}
