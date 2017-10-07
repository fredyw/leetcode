package leetcode;

/**
 * https://leetcode.com/problems/continuous-subarray-sum/
 */
public class Problem523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem523 prob = new Problem523();
        System.out.println(prob.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6)); // true
        System.out.println(prob.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6)); // true
    }
}
