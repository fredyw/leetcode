package leetcode;

/**
 * https://leetcode.com/problems/house-robber-ii/
 */
public class Problem213 {
    public int rob(int[] nums) {
        int answer = 0;
        if (nums.length == 1) {
            return nums[nums.length - 1];
        }
        for (int i = 0; i < nums.length - 1; i++) {
            Integer[] memo = new Integer[nums.length];
            int a = rob(nums, true, i, memo);
            memo = new Integer[nums.length];
            int b = rob(nums, false, i + 1, memo);
            answer = Math.max(answer, Math.max(a, b));
        }
        return answer;
    }

    private static int rob(int[] nums, boolean first, int idx, Integer[] memo) {
        if (idx == nums.length - 1) {
            if (first) {
                return 0;
            }
            return nums[idx];
        }
        if (idx >= nums.length) {
            return 0;
        }
        if (memo[idx] != null) {
            return memo[idx];
        }
        int answer = nums[idx];
        int a = rob(nums, first, idx + 2, memo);
        int b = rob(nums, first, idx + 3, memo);
        answer += Math.max(a, b);
        memo[idx] = answer;
        return answer;
    }
}
