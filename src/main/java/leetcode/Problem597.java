package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-harmonious-subsequence/
 */
public class Problem597 {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        int max = 0;
        for (Integer i : map.keySet()) {
            int count = map.get(i);
            int c1 = map.getOrDefault(i + 1, 0);
            int c2 = map.getOrDefault(i - 1, 0);
            if (c1 == 0 && c2 == 0) {
                max = Math.max(max, 0);
            } else {
                max = Math.max(max, Math.max(count + c1, count + c2));
            }
        }
        return max;
    }
}
