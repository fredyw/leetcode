package leetcode;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 */
public class Problem188 {
    public int maxProfit(int k, int[] prices) {
        // the k can be ridiculously high.
        if (k >= prices.length / 2) {
            return quickSolve(prices);
        }
        Integer[][][] memo = new Integer[k + 1][prices.length + 1][2];
        return maxProfit(k, prices, 0, true, memo);
    }

    private static int quickSolve(int[] prices) {
        int len = prices.length;
        int profit = 0;
        for (int i = 1; i < len; i++) {
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        }
        return profit;
    }

    private static int maxProfit(int k, int[] prices, int index, boolean buy,
                                 Integer[][][] memo) {
        if (k == 0 || prices.length == index) {
            return 0;
        }
        if (memo[k][index][buy ? 0 : 1] != null) {
            return memo[k][index][buy ? 0 : 1];
        }
        int max = 0;
        int a = 0;
        if (buy) {
            a = maxProfit(k, prices, index + 1, !buy, memo) - prices[index]; // buy
        } else {
            a = maxProfit(k - 1, prices, index + 1, !buy, memo) + prices[index]; // sell
        }
        int b = maxProfit(k, prices, index + 1, buy, memo); // skip
        max = Math.max(max, Math.max(a, b));
        memo[k][index][buy ? 0 : 1] = max;
        return max;
    }
}
