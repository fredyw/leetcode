package leetcode;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class Problem123 {
    public int maxProfit(int[] prices) {
        return maxProfit(prices, 0, 1, new Integer[prices.length][5]);
    }

    private static int maxProfit(int[] prices, int i, int count,
                                 Integer[][] memo) {
        if (i >= prices.length || count > 4) {
            return 0;
        }
        if (memo[i][count] != null) {
            return memo[i][count];
        }
        int max = 0;
        int left = maxProfit(prices, i + 1, count + 1, memo);
        int right = maxProfit(prices, i + 1, count, memo);
        if (count % 2 != 0) { // buy
            max = Math.max(left - prices[i], right);
        } else { // sell
            max = Math.max(left + prices[i], right);
        }
        memo[i][count] = max;
        return max;
    }
}
