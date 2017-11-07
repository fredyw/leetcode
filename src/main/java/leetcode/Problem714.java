package leetcode;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 */
public class Problem714 {
    public int maxProfit(int[] prices, int fee) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem714 prob = new Problem714();
        System.out.println(prob.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2)); // 8
        System.out.println(prob.maxProfit(new int[]{1, 3, 2, 6, 8, 4, 9}, 2)); // 8
        System.out.println(prob.maxProfit(new int[]{1, 4, 2, 1, 4, 8, 4, 9}, 2)); // 9
    }
}
