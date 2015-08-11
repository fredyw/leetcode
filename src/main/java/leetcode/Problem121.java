package leetcode;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class Problem121 {
    public int maxProfit(int[] prices) {
        int[] max = new int[prices.length];
        int m = -1;
        for (int i = prices.length-1; i != 0; i--) {
            max[i] = Math.max(m, prices[i]);
            m = max[i];
        }
        int profit = 0;
        for (int i = 0; i < prices.length-1; i++) {
            int buy = prices[i];
            int sell = max[i+1];
            profit = Math.max(profit, sell-buy);
        }
        return profit;
    }
    
    public static void main(String[] args) {
        Problem121 prob = new Problem121();
        System.out.println(prob.maxProfit(new int[]{1, 2, 4, 2, 1, 3}));
        System.out.println(prob.maxProfit(new int[]{3, 2, 6, 5, 0, 3}));
    }
}
