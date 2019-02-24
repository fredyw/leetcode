package leetcode;

/**
 * https://leetcode.com/problems/maximum-sum-circular-subarray/
 */
public class Problem918 {
    public int maxSubarraySumCircular(int[] A) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem918 prob = new Problem918();
        System.out.println(prob.maxSubarraySumCircular(new int[]{1, -2, 3, -2})); // 3
        System.out.println(prob.maxSubarraySumCircular(new int[]{5, -3, 5})); // 10
        System.out.println(prob.maxSubarraySumCircular(new int[]{3, -1, 2, -1})); // 4
        System.out.println(prob.maxSubarraySumCircular(new int[]{3, -2, 2, -3})); // 3
        System.out.println(prob.maxSubarraySumCircular(new int[]{-2, -3, -1})); // -1
    }
}
