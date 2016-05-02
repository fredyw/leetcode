package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
public class Problem347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        ArrayList<Entry<Integer, Integer>> sortedList = new ArrayList<>(map.entrySet());
        sortedList.sort((x, y) -> y.getValue().compareTo(x.getValue()));
        for (int i = 0; i < k; i++) {
            Integer element = sortedList.get(i).getKey();
            result.add(element);
        }
        return result;
    }
}
