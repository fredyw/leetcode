package leetcode;

/**
 * https://leetcode.com/problems/minimum-deletion-cost-to-avoid-repeating-letters/
 */
public class Problem1578 {
    public int minCost(String s, int[] cost) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1578 prob = new Problem1578();
        System.out.println(prob.minCost("abaac", new int[]{1,2,3,4,5})); // 3
        System.out.println(prob.minCost("abc", new int[]{1,2,3})); // 0
        System.out.println(prob.minCost("aabaa", new int[]{1,2,3,4,1})); // 2
        System.out.println(prob.minCost("aabaaa", new int[]{1,2,3,4,1,5})); // 6
    }
}
