package leetcode;

/**
 * https://leetcode.com/problems/maximum-number-of-coins-you-can-get/
 */
public class Problem1561 {
    public int maxCoins(int[] piles) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1561 prob = new Problem1561();
        System.out.println(prob.maxCoins(new int[]{2,4,1,2,7,8})); // 9
        System.out.println(prob.maxCoins(new int[]{2,4,5})); // 4
        System.out.println(prob.maxCoins(new int[]{9,8,7,6,5,1,2,3,4})); // 18
    }
}
