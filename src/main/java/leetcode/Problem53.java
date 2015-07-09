package leetcode;

/**
 * https://leetcode.com/problems/maximum-subarray/
 */
public class Problem53 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        int maxSoFar = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxSoFar = Math.max(nums[i], maxSoFar + nums[i]);
            max = Math.max(max, maxSoFar);
        }
        return max;
    }
}
