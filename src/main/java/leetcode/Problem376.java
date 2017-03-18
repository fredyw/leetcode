package leetcode;

/**
 * https://leetcode.com/problems/wiggle-subsequence/
 */
public class Problem376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int a = wiggleMaxLength(nums, 1, 0, true, createMemo(nums.length));
        int b = wiggleMaxLength(nums, 1, 0, false, createMemo(nums.length));
        return Math.max(a, b);
    }

    private static int[][] createMemo(int length) {
        int[][] memo = new int[length][length];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo.length; j++) {
                memo[i][j] = -1;
            }
        }
        return memo;
    }

    private static int wiggleMaxLength(int[] nums, int idx, int prevIdx, boolean positive,
                                       int[][] memo) {
        if (idx == nums.length) {
            return 1;
        }
        if (memo[idx][prevIdx] != -1) {
            return memo[idx][prevIdx];
        }
        int max = 0;
        if ((nums[idx] - nums[prevIdx] > 0 && positive) ||
            (nums[idx] - nums[prevIdx] < 0 && !positive)) {
            max = Math.max(max, wiggleMaxLength(nums, idx + 1, idx, !positive, memo) + 1);
        }
        max = Math.max(max, wiggleMaxLength(nums, idx + 1, prevIdx, positive, memo));
        memo[idx][prevIdx] = max;
        return max;
    }
}
