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

    public static void main(String[] args) {
        Problem300 prob = new Problem300();
        System.out.println(prob.lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9})); // 3
        System.out.println(prob.lengthOfLIS(new int[]{3, 5, 2, 4})); // 2
        System.out.println(prob.lengthOfLIS(new int[]{1})); // 1
        System.out.println(prob.lengthOfLIS(new int[]{1, 2})); // 2
        System.out.println(prob.lengthOfLIS(new int[]{1, 2, 3})); // 3
        System.out.println(prob.lengthOfLIS(new int[]{})); // 0
        System.out.println(prob.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18})); // 4
    }
}
