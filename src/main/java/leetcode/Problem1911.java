package leetcode;

/**
 * https://leetcode.com/problems/maximum-alternating-subsequence-sum/
 */
public class Problem1911 {
    public long maxAlternatingSum(int[] nums) {
        return maxAlternatingSum(nums, 0, true, new Long[nums.length][2]);
    }

    private static long maxAlternatingSum(int[] nums, int i, boolean odd, Long[][] memo) {
        if (i == nums.length) {
            return 0;
        }
        if (memo[i][odd ? 0 : 1] != null) {
            return memo[i][odd ? 0 : 1];
        }
        long a = maxAlternatingSum(nums, i + 1, !odd, memo) + (odd ? nums[i] : -nums[i]);
        long b = maxAlternatingSum(nums, i + 1, odd, memo);
        long max = Math.max(a, b);
        memo[i][odd ? 0 : 1] = max;
        return max;
    }
}
