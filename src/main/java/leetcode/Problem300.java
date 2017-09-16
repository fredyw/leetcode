package leetcode;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class Problem300 {
    public int lengthOfLIS(int[] nums) {
        int max = 0;
        Integer[] memo = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, lengthOfLIS(nums, i, memo) + 1);
        }
        return max;
    }

    private static int lengthOfLIS(int[] nums, int idx, Integer[] memo) {
        if (memo[idx] != null) {
            return memo[idx];
        }
        int max = 0;
        for (int i = idx; i < nums.length; i++) {
            if (nums[idx] < nums[i]) {
                max = Math.max(max, lengthOfLIS(nums, i, memo) + 1);
            }
        }
        memo[idx] = max;
        return max;
    }
}
