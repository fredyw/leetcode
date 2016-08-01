package leetcode;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class Problem121 {
    public int maxProfit(int[] prices) {
        int[] max = new int[prices.length];
        int m = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            max[i] = Math.max(m, prices[i]);
            m = max[i];
        }
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int buy = prices[i];
            int sell = max[i + 1];
            profit = Math.max(profit, sell - buy);
        }
        return profit;
    }
}
