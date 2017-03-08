package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/
 */
public class Problem532 {
    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        int result = 0;
        Set<String> set = new HashSet<>();
        for (int num : nums) {
            String key = Math.min(num, num + k) + "|" + Math.max(num, num + k);
            if (!set.contains(key)) {
                int val = (num == num + k) ? 1 : 0;
                if (map.containsKey(num + k) && map.get(num + k) > val) {
                    map.put(num + k, map.get(num + k) - 1);
                    set.add(key);
                    result++;
                }
            }
        }
        return result;
    }
}
