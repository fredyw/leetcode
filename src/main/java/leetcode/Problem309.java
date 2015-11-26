package leetcode;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
public class Problem309 {
    public int maxProfit(int[] prices) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem309 prob = new Problem309();
        System.out.println(prob.maxProfit(new int[]{1, 2, 3, 0, 2})); // 3
        System.out.println(prob.maxProfit(new int[]{1, 2, 3, 0, 2, 4})); // 5
        System.out.println(prob.maxProfit(new int[]{3, 2, 1})); // 0
        System.out.println(prob.maxProfit(new int[]{1, 2, 3})); // 2
        System.out.println(prob.maxProfit(new int[]{3, 0, 0, 0, 5})); // 5
    }
}
