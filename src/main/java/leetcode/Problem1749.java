package leetcode;

/**
 * https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/
 */
public class Problem1749 {
    public int maxAbsoluteSum(int[] nums) {
        int max = nums[0];
        int maxSoFar = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxSoFar = Math.max(maxSoFar + nums[i], nums[i]);
            max = Math.max(max, maxSoFar);
        }
        int min = nums[0];
        int minSoFar = nums[0];
        for (int i = 1; i < nums.length; i++) {
            minSoFar = Math.min(minSoFar + nums[i], nums[i]);
            min = Math.min(min, minSoFar);
        }
        return Math.max(Math.abs(max), Math.abs(min));
    }
}
