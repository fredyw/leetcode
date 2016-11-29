package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/burst-balloons/
 */
public class Problem312 {
    public int maxCoins(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        Map<String, Integer> memo = new HashMap<>();
        return maxCoins(list, 0, list.size() - 1, memo);
    }

    private static int maxCoins(List<Integer> nums, int start, int end, Map<String, Integer> memo) {
        if (start > end) {
            return 0;
        }
        String key = start + "|" + end;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int max = 0;
        int left = 1;
        int right = 1;
        if (start - 1 >= 0) {
            left = nums.get(start - 1);
        }
        if (end + 1 < nums.size()) {
            right = nums.get(end + 1);
        }
        for (int i = start; i <= end; i++) {
            int val = left * nums.get(i) * right;
            int a = maxCoins(nums, start, i - 1, memo);
            int b = maxCoins(nums, i + 1, end, memo);
            int total = a + val + b;
            max = Math.max(max, total);
        }
        memo.put(key, max);
        return max;
    }
}
