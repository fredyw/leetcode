package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class Problem123 {
    public int maxProfit(int[] prices) {
        return maxProfit(prices, 0, 0, new HashMap<>());
    }

    private static int maxProfit(int[] prices, int i, int count,
                                 Map<Integer, Integer> memo) {
        if (count >= 2) {
            return 0;
        }
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        int max = 0;
        for (int x = i; x < prices.length; x++) {
            for (int y = x + 1; y < prices.length; y++) {
                if (prices[x] < prices[y]) {
                    int diff = prices[y] - prices[x];
                    int profit = maxProfit(prices, y + 1, count + 1, memo) + diff;
                    max = Math.max(max, profit);
                }
            }
        }
        memo.put(i, max);
        return max;
    }

    public static void main(String[] args) {
        Problem123 prob = new Problem123();
        System.out.println(prob.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4})); // 6
        System.out.println(prob.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4, 4, 9, 8, 10})); // 12
        System.out.println(prob.maxProfit(new int[]{1, 2, 3, 4, 5})); // 4
        System.out.println(prob.maxProfit(new int[]{7, 6, 4, 3, 1})); // 0
        System.out.println(prob.maxProfit(new int[]{5, 2, 3})); // 1
        System.out.println(prob.maxProfit(new int[]{3, 2, 6, 5, 0, 3})); // 7
        System.out.println(prob.maxProfit(new int[]{2, 6, 5, 0, 3})); // 7
        System.out.println(prob.maxProfit(new int[]{2, 5, 6, 0, 3})); // 7
        System.out.println(prob.maxProfit(new int[]{3, 2, 5, 6, 0, 3})); // 7
    }
}
