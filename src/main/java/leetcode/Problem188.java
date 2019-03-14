package leetcode;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 */
public class Problem188 {
    public int maxProfit(int k, int[] prices) {
        Integer[][][] memo = new Integer[k + 1][prices.length + 1][2];
        return maxProfit(k, prices, 0, true, memo);
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

    public static void main(String[] args) {
        Problem188 prob = new Problem188();
        System.out.println(prob.maxProfit(2, new int[]{2, 4, 1})); // 2
        System.out.println(prob.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3})); // 7
   }
}
