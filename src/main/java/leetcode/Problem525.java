package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/contiguous-array/
 */
public class Problem525 {
    public int findMaxLength(int[] nums) {
        int max = 0;
        // count -> index
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count--;
            } else {
                count++;
            }
            if (count == 0) {
                max = Math.max(max, i + 1);
            } else {
                if (map.containsKey(count)) {
                    max = Math.max(max, i - map.get(count));
                } else {
                    map.put(count, i);
                }
            }
        }
        return max;
    }
}
