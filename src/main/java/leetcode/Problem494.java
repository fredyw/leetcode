package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/target-sum/
 */
public class Problem494 {
    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWays(nums, S, 0, new HashMap<>());
    }

    private static int findTargetSumWays(int[] nums, int s, int idx, Map<String, Integer> memo) {
        if (idx == nums.length) {
            return (s == 0) ? 1 : 0;
        }
        String key = s + "|" + idx;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int answer = findTargetSumWays(nums, s - nums[idx], idx + 1, memo) +
            findTargetSumWays(nums, s + nums[idx], idx + 1, memo);
        memo.put(key, answer);
        return answer;
    }
}
