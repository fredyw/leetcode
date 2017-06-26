package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-product-of-three-numbers/
 */
public class Problem628 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        boolean positive = false;
        boolean negative = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negative = true;
            } else {
                positive = true;
            }
        }
        if (negative && positive) {
            int a = nums[nums.length - 2] * nums[nums.length - 3];
            int b = nums[0] * nums[1];
            return nums[nums.length - 1] * Math.max(a, b);
        }
        return nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
    }
}
