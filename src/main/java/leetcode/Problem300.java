package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class Problem300 {
    public int lengthOfLIS(int[] nums) {
        int maxLength = 0;
        Map<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int length = lengthOfLIS(nums, i, memo) + 1;
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }

    private int lengthOfLIS(int[] nums, int idx, Map<Integer, Integer> memo) {
        if (memo.containsKey(idx)) {
            return memo.get(idx);
        }
        int maxLength = 0;
        for (int i = idx; i < nums.length; i++) {
            if (nums[idx] < nums[i]) {
                int length = lengthOfLIS(nums, i, memo) + 1;
                maxLength = Math.max(maxLength, length);
            }
        }
        memo.put(idx, maxLength);
        return maxLength;
    }
}
