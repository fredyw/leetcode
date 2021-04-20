package leetcode;

/**
 * https://leetcode.com/problems/minimum-operations-to-make-the-array-increasing/
 */
public class Problem1827 {
    public int minOperations(int[] nums) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1827 prob = new Problem1827();
        System.out.println(prob.minOperations(new int[]{1,1,1})); // 3
        System.out.println(prob.minOperations(new int[]{1,5,2,4,1})); // 14
        System.out.println(prob.minOperations(new int[]{8})); // 0
    }
}
