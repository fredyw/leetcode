package leetcode;

/**
 * https://leetcode.com/problems/continuous-subarray-sum/
 */
public class Problem523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (nums.length == 1) {
            return false;
        }
        if (sum == 0 && k == 0 && nums.length > 1) {
            return true;
        }
        for (int i = nums.length; i >= 0; i--) {
            if (i < nums.length) {
                sum -= nums[i];
            }
            int tmp = sum;
            for (int j = 0; j < i; j++) {
                if (k != 0) {
                    if (tmp % k == 0 && i - j > 1) {
                        return true;
                    }
                } else if (k == 0 && tmp == 0 && i - j > 1) {
                    return true;
                }
                tmp -= nums[j];
            }
        }
        return false;
    }
}
