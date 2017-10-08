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

    public static void main(String[] args) {
        Problem523 prob = new Problem523();
        System.out.println(prob.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6)); // true
        System.out.println(prob.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6)); // true
        System.out.println(prob.checkSubarraySum(new int[]{23, 2, 6, 4, 8}, 6)); // true
        System.out.println(prob.checkSubarraySum(new int[]{1, 2, 3}, 4)); // false
        System.out.println(prob.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 0)); // false
        System.out.println(prob.checkSubarraySum(new int[]{0, 0}, 0)); // true
        System.out.println(prob.checkSubarraySum(new int[]{0}, 0)); // false
        System.out.println(prob.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, -6)); // true
        System.out.println(prob.checkSubarraySum(new int[]{0}, -1)); // false
        System.out.println(prob.checkSubarraySum(new int[]{0, 0, 1}, 0)); // true
        System.out.println(prob.checkSubarraySum(new int[]{0, 2}, 0)); // false
    }
}
