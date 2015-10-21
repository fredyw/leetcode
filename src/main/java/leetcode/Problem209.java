package leetcode;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 */
public class Problem209 {
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= s) {
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return (min == Integer.MAX_VALUE) ? 0 : min;
    }
}
