package leetcode;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
public class Problem309 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int[] states1 = new int[prices.length];
        int[] states2 = new int[prices.length];
        int[] states3 = new int[prices.length];
        states1[0] = 0;
        states2[0] = -prices[0];
        states3[0] = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            states1[i] = Math.max(states1[i - 1], states3[i - 1]);
            states2[i] = Math.max(states2[i - 1], states1[i - 1] - prices[i]);
            states3[i] = states2[i - 1] + prices[i];
        }
        return Math.max(states1[prices.length - 1], states3[prices.length - 1]);
    }
}
