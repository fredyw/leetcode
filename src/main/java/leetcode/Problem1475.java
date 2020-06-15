package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/
 */
public class Problem1475 {
    public int[] finalPrices(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int discount = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    discount = prices[j];
                    break;
                }
            }
            answer[i] = prices[i] - discount;
        }
        return answer;
    }
}
