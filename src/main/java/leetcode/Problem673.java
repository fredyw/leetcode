package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence/
 */
public class Problem673 {
    public int findNumberOfLIS(int[] nums) {
        Integer[] memo = new Integer[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        int max = longestIncreasingSubsequence(nums, 0, memo, map);
        return map.get(max);
    }

    private static int longestIncreasingSubsequence(int[] nums, int idx, Integer[] memo,
                                                    Map<Integer, Integer> map) {
        if (idx == nums.length) {
            return 0;
        }
//        if (memo[idx] != null) {
//            int max = memo[idx];
//            if (!map.containsKey(max)) {
//                map.put(max, 1);
//            } else {
//                map.put(max, map.get(max) + 1);
//            }
//            System.out.println("max: " + max);
//            return max;
//        }
        int max = 0;
        for (int i = idx + 1; i < nums.length; i++) {
            if (nums[idx] < nums[i]) {
                max = Math.max(max, longestIncreasingSubsequence(nums, i, memo, map) + 1);
            }
            max = Math.max(max, longestIncreasingSubsequence(nums, i, memo, map));
        }
        memo[idx] = max;
        if (!map.containsKey(max)) {
            map.put(max, 1);
        } else {
            map.put(max, map.get(max) + 1);
        }
//        System.out.println("max: " + max);
        return max;
    }

    public static void main(String[] args) {
        Problem673 prob = new Problem673();
//        System.out.println(prob.findNumberOfLIS(new int[]{1, 3, 5, 4, 7})); // 2
//        System.out.println(prob.findNumberOfLIS(new int[]{2, 2, 2, 2, 2})); // 5
        System.out.println(prob.findNumberOfLIS(new int[]{1, 2, 3, 4, 5})); // 1
        System.out.println(prob.findNumberOfLIS(new int[]{1, 3, 3, 4, 5})); // 2
    }
}
