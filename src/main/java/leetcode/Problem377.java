package leetcode;

/**
 * https://leetcode.com/problems/combination-sum-iv/
 */
public class Problem377 {
    public int combinationSum4(int[] nums, int target) {
        Integer[] memo = new Integer[target + 1];
        return combinationSum4(nums, target, memo);
    }

    private static int combinationSum4(int[] nums, int target, Integer[] memo) {
        if (target < 0) {
            return 0;
        }
        if (target == 0) {
            return 1;
        }
        if (memo[target] != null) {
            return memo[target];
        }
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            answer += combinationSum4(nums, target - nums[i], memo);
        }
        memo[target] = answer;
        return answer;
    }
}
