package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class Problem1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new HashSet<>());
            }
            map.get(nums[i]).add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            int a = target - nums[i];
            if (!map.containsKey(a)) {
                continue;
            }
            Set<Integer> indexes = map.get(a);
            if (a == nums[i] && indexes.size() == 1) {
                continue;
            }
            indexes.remove(i);
            return new int[]{i, indexes.iterator().next()};
        }
        return new int[]{};
    }
}
