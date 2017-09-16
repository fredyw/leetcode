package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence/
 */
public class Problem673 {
    public int findNumberOfLIS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        Integer[] memo = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int longest = longestIncreasingSubsequence(nums, i, memo) + 1;
            max = Math.max(max, longest);
            if (!map.containsKey(longest)) {
                map.put(longest, 1);
            } else {
                map.put(longest, map.get(longest) + 1);
            }
        }
        return map.get(max);
    }

    private static int longestIncreasingSubsequence(int[] nums, int idx, Integer[] memo) {
        if (memo[idx] != null) {
            return memo[idx];
        }
        int max = 0;
        for (int i = idx; i < nums.length; i++) {
            if (nums[idx] < nums[i]) {
                max = Math.max(max, longestIncreasingSubsequence(nums, i, memo) + 1);
            }
        }
        memo[idx] = max;
        return max;
    }

    public static void main(String[] args) {
        Problem673 prob = new Problem673();
//        System.out.println(prob.findNumberOfLIS(new int[]{1, 2})); // 1
//        System.out.println(prob.findNumberOfLIS(new int[]{3, 5, 2, 4})); // 2
        System.out.println(prob.findNumberOfLIS(new int[]{1, 3, 5, 4, 7})); // 2
//        System.out.println(prob.findNumberOfLIS(new int[]{2, 2, 2, 2, 2})); // 5
//        System.out.println(prob.findNumberOfLIS(new int[]{1, 2, 3, 4, 5})); // 1
//        System.out.println(prob.findNumberOfLIS(new int[]{1, 3, 3, 4, 5})); // 2
    }
}
