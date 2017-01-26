package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/predict-the-winner/
 */
public class Problem486 {
    public boolean PredictTheWinner(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int val = predict(nums, 0, nums.length - 1, new HashMap<>());
        return val >= (sum - val);
    }

    private static int predict(int[] nums, int start, int end, Map<String, Integer> memo) {
        if (start > end) {
            return 0;
        }
        String key = start + "|" + end;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int a = nums[start] + Math.min(predict(nums, start + 2, end, memo),
            predict(nums, start + 1, end - 1, memo));
        int b = nums[end] + Math.min(predict(nums, start, end - 2, memo),
            predict(nums, start + 1, end - 1, memo));
        int max = Math.max(a, b);
        memo.put(key, max);
        return max;
    }
}
