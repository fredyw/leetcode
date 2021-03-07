package leetcode;

/**
 * https://leetcode.com/problems/closest-dessert-cost/
 */
public class Problem1774 {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1774 prob = new Problem1774();
        System.out.println(prob.closestCost(new int[]{1,7}, new int[]{3,4}, 10)); // 10
        System.out.println(prob.closestCost(new int[]{2,3}, new int[]{4,5,100}, 18)); // 17
        System.out.println(prob.closestCost(new int[]{3,10}, new int[]{2,5}, 9)); // 8
        System.out.println(prob.closestCost(new int[]{10}, new int[]{1}, 1)); // 10
    }
}
