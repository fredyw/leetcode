package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/coin-change-2/
 */
public class Problem518 {
    public int change(int amount, int[] coins) {
        return coinChange(amount, coins, 0, new HashMap<>());
    }

    private static int coinChange(int amount, int[] coins, int idx, Map<Integer, Integer> memo) {
        if (amount <= 0) {
            if (amount == 0) {
                return 1;
            }
            return 0;
        }
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }
        int count = 0;
        for (int i = idx; i < coins.length; i++) {
            count += coinChange(amount - coins[i], coins, i, memo);
        }
        memo.put(amount, count);
        return count;
    }

    public static void main(String[] args) {
        Problem518 prob = new Problem518();
        System.out.println(prob.change(5, new int[]{1, 2, 5})); // 4
//        System.out.println(prob.change(3, new int[]{2})); // 0
//        System.out.println(prob.change(10, new int[]{10})); // 1
    }
}