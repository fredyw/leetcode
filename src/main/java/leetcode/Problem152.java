package leetcode;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 */
public class Problem152 {
    public int maxProduct(int[] nums) {
        int answer = nums[0];
        int product = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (product * nums[i] == 0) {
                product = nums[i];
            } else {
                product *= nums[i];
            }
            int max = Math.max(nums[i], product);
            answer = Math.max(answer, max);
        }
        product = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (product * nums[i] == 0) {
                product = nums[i];
            } else {
                product *= nums[i];
            }
            int max = Math.max(nums[i], product);
            answer = Math.max(answer, max);
        }
        return answer;
    }
}
