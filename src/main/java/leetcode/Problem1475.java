package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/
 */
public class Problem1475 {
    public int[] finalPrices(int[] prices) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1475 prob = new Problem1475();
        System.out.println(Arrays.toString(prob.finalPrices(new int[]{8,4,6,2,3}))); // [4,2,4,2,3]
        System.out.println(Arrays.toString(prob.finalPrices(new int[]{1,2,3,4,5}))); // [1,2,3,4,5]
        System.out.println(Arrays.toString(prob.finalPrices(new int[]{10,1,1,6}))); // [9,0,1,6]
    }
}
