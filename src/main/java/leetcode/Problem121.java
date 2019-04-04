package leetcode;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class Problem121 {
    public int maxProfit(int[] prices) {
        int[] maxPrices = new int[prices.length];
        int maxPrice = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            maxPrices[i] = maxPrice;
        }
        int answer = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            answer = Math.max(answer, maxPrices[i + 1] - prices[i]);
        }
        return answer;
    }
}
