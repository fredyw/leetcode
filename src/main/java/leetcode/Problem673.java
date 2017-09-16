package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence/
 */
public class Problem673 {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int count = 1;
        MaxCount[] memo = new MaxCount[nums.length];
        for (int i = 0; i < nums.length; i++) {
            MaxCount mc = longestIncreasingSubsequence(nums, i, memo);
            int longest = mc.max + 1;
            if (max < longest) {
                count += mc.count;
            } else if (max == longest) {
                count += mc.count;
            }
            max = Math.max(max, longest);
        }
        return count;
    }

    private static class MaxCount {
        private final int max;
        private final int count;

        public MaxCount(int max, int count) {
            this.max = max;
            this.count = count;
        }
    }

    private static MaxCount longestIncreasingSubsequence(int[] nums, int idx, MaxCount[] memo) {
        if (memo[idx] != null) {
            return memo[idx];
        }
        int max = 0;
        int count = 1;
        for (int i = idx; i < nums.length; i++) {
            if (nums[idx] < nums[i]) {
                MaxCount mc = longestIncreasingSubsequence(nums, i, memo);
                int longest = mc.max + 1;
                if (max < longest) {
                    count += mc.count;
                } else if (max == longest) {
                    count += mc.count;
                }
                max = Math.max(max, longest);
            }
        }
        MaxCount maxCount = new MaxCount(max, count);
        memo[idx] = maxCount;
        return maxCount;
    }
}
