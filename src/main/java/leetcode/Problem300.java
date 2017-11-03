package leetcode;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class Problem300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 0;
        int[] memo = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int tmpMax = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    tmpMax = Math.max(tmpMax, memo[j] + 1);
                }
            }
            memo[i] = tmpMax;
            max = Math.max(max, tmpMax);
        }
        return max + 1;
    }

//    public int lengthOfLIS(int[] nums) {
//        int max = 0;
//        Integer[] memo = new Integer[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            max = Math.max(max, lengthOfLIS(nums, i, memo) + 1);
//        }
//        return max;
//    }
//
//    private static int lengthOfLIS(int[] nums, int idx, Integer[] memo) {
//        if (memo[idx] != null) {
//            return memo[idx];
//        }
//        int max = 0;
//        for (int i = idx; i < nums.length; i++) {
//            if (nums[idx] < nums[i]) {
//                max = Math.max(max, lengthOfLIS(nums, i, memo) + 1);
//            }
//        }
//        memo[idx] = max;
//        return max;
//    }
}
