package leetcode;

/**
 * https://leetcode.com/problems/target-sum/
 */
public class Problem494 {
    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWays(nums, S, 0);
    }

    private static int findTargetSumWays(int[] nums, int s, int idx) {
        if (idx == nums.length) {
            return (s == 0) ? 1 : 0;
        }
        return findTargetSumWays(nums, s - nums[idx], idx + 1) +
            findTargetSumWays(nums, s + nums[idx], idx + 1);
    }
}
