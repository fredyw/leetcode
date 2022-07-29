package leetcode;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 */
public class Problem152 {
    public int maxProduct(int[] nums) {
        int answer = nums[0];
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = Math.max(nums[i], Math.max(nums[i] * min, nums[i] * max));
            min = Math.min(nums[i], Math.min(nums[i] * min, nums[i] * max));
            max = tmp;
            answer = Math.max(answer, max);
        }
        return answer;
    }
}
