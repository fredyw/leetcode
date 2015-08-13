package leetcode;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class Problem122 {
    public int maxProfit(int[] prices) {
        boolean buy = true;
        int profit = 0;
        int buyPrice = Integer.MAX_VALUE;
        int sellPrice = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (buy) {
                if (buyPrice < prices[i]) {
                    sellPrice = prices[i];
                    buy = false;
                } else {
                    buyPrice = prices[i];
                }
            } else { // sell
                if (sellPrice > prices[i]) {
                    profit += sellPrice - buyPrice;
                    buy = true;
                    buyPrice = prices[i];
                    sellPrice = Integer.MIN_VALUE;
                } else {
                    sellPrice = prices[i];
                }
            }
        }
        if (buyPrice < sellPrice) {
            profit += sellPrice - buyPrice;
        }
        return profit;
    }
}
