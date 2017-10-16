package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/degree-of-an-array/
 */
public class Problem697 {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            if (!left.containsKey(nums[i])) {
                left.put(nums[i], i);
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (!right.containsKey(nums[i])) {
                right.put(nums[i], i);
            }
        }
        int max = 0;
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (max < entry.getValue()) {
                list.clear();
                list.add(entry.getKey());
                max = entry.getValue();
            } else if (max == entry.getValue()) {
                list.add(entry.getKey());
            }
        }
        int result = Integer.MAX_VALUE;
        for (int num : list) {
            result = Math.min(result, right.get(num) - left.get(num) + 1);
        }
        return result;
    }
}
