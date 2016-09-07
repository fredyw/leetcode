package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/combination-sum-iv/
 */
public class Problem377 {
    public int combinationSum4(int[] nums, int target) {
        return combinationSum(nums, target, new HashMap<>());
    }

    private int combinationSum(int[] nums, int target, Map<Integer, Integer> memo) {
        if (target < 0) {
            return 0;
        }
        if (target == 0) {
            return 1;
        }
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += combinationSum(nums, target - nums[i], memo);
        }
        memo.put(target, count);
        return count;
    }
}
