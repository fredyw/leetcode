package leetcode;

/**
 * https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/
 */
public class Problem1186 {
    public int maximumSum(int[] arr) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1186 prob = new Problem1186();
        System.out.println(prob.maximumSum(new int[]{1, -2, 0, 3})); // 4
        System.out.println(prob.maximumSum(new int[]{1, -2, -2, 3})); // 3
        System.out.println(prob.maximumSum(new int[]{-1, -1, -1, -1})); // -1
        System.out.println(prob.maximumSum(new int[]{1, -2, -1, 0, 3})); // 3
        System.out.println(prob.maximumSum(new int[]{1, 2, 3})); // 6
    }
}
