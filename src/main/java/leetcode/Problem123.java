package leetcode;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class Problem123 {
    public int maxProfit(int[] prices) {
        // TODO
        return 0;
    }

//    private static int maxProfit(int[] prices, int i) {
//        for (int j = i + 1; j < prices.length; j++) {
//            if (prices[i] > prices[j]) {
//                maxProfit(prices, j + 1);
//            }
//        }
//    }

    public static void main(String[] args) {
        Problem123 prob = new Problem123();
        System.out.println(prob.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4})); // 6
        System.out.println(prob.maxProfit(new int[]{1, 2, 3, 4, 5})); // 4
        System.out.println(prob.maxProfit(new int[]{7, 6, 4, 3, 1})); // 0
    }
}
