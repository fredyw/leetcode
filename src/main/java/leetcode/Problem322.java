package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/coin-change/
 */
public class Problem322 {
    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> memo = new HashMap<>();
        int result = coinChange(coins, amount, memo);
        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        return result - 1;
    }

    private int coinChange(int[] coins, int amount, Map<Integer, Integer> memo) {
        if (amount < 0) {
            return Integer.MAX_VALUE;
        } else if (amount == 0) {
            return 1;
        }
        if (memo.containsKey(amount)) {
            return memo.get(amount);
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
        memo.put(amount, result);
        return result;
    }
}
