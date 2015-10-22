package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/house-robber-ii/
 */
public class Problem213 {
    public int rob(int[] nums) {
        int max = 0;
        if (nums.length == 1) {
            return nums[nums.length-1];
        }
        for (int i = 0; i < nums.length-1; i++) {
            Map<Integer, Value> memo = new HashMap<>();
            Value a = rob(nums, i, memo);
            Value b = rob(nums, i+1, memo);
            int tmpMax = Math.max(a.value0, b.value1);
            max = Math.max(max, tmpMax);
        }
        return max;
    }

    private static class Value {
        int value0;
        int value1;
    }

    private Value rob(int[] nums, int idx, Map<Integer, Value> memo) {
        if (memo.containsKey(idx)) {
            return memo.get(idx);
        }
        if (idx == nums.length-1) {
            Value value = new Value();
            value.value0 = 0;
            value.value1 = nums[idx];
            return value;
        }
        if (idx >= nums.length) {
            return new Value();
        }
        Value a = rob(nums, idx+2, memo);
        Value b = rob(nums, idx+3, memo);
        int val = nums[idx];
        int max0 = Math.max(a.value0 + val, b.value0 + val);
        int max1 = Math.max(a.value1 + val, b.value1 + val);
        Value value = new Value();
        value.value0 = max0;
        value.value1 = max1;
        memo.put(idx, value);
        return value;
    }
}
