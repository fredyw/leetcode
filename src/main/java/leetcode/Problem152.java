package leetcode;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 */
public class Problem152 {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int tmpMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (tmpMax * nums[i] == 0) {
                tmpMax = nums[i];
            } else {
                tmpMax *= nums[i];
            }
            max = Math.max(Math.max(tmpMax, nums[i]), max);
        }
        tmpMax = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (tmpMax * nums[i] == 0) {
                tmpMax = nums[i];
            } else {
                tmpMax *= nums[i];
            }
            max = Math.max(Math.max(tmpMax, nums[i]), max);
        }
        return max;
    }
}
