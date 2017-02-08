package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/relative-ranks/
 */
public class Problem506 {
    public String[] findRelativeRanks(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < copy.length; i++) {
            list.add(copy[i]);
        }
        Collections.sort(list, (a, b) -> Integer.compare(b, a));
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i + 1);
        }
        String[] result = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int position = map.get(nums[i]);
            if (position == 1) {
                result[i] = "Gold Medal";
            } else if (position == 2) {
                result[i] = "Silver Medal";
            } else if (position == 3) {
                result[i] = "Bronze Medal";
            } else {
                result[i] = Integer.toString(position);
            }
        }
        return result;
    }
}
