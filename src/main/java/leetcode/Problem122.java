package leetcode;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class Problem122 {
    public int maxProfit(int[] prices) {
        int answer = 0;
        int i = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            int buy = prices[i];
            while (i < prices.length - 1&& prices[i] <= prices[i + 1]) {
                i++;
            }
            int sell = prices[i];
            answer += sell - buy;
        }
        return answer;
    }
}
