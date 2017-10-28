package leetcode;

/**
 * https://leetcode.com/problems/subarray-product-less-than-k/
 */
public class Problem713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 0) {
            return 0;
        }
        int result = 0;
        int left = 0;
        int product = 1;
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (product >= k) {
                if (left > right) {
                    break;
                }
                product /= nums[left];
                left++;
            }
            result += right - left + 1;
        }
        return result;
    }
}
