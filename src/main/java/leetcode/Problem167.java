package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class Problem167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] array = new int[2];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (!map.containsKey(numbers[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i + 1);
                map.put(numbers[i], list);
            } else {
                map.get(numbers[i]).add(i + 1);
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            int a = target - numbers[i];
            if (map.containsKey(a)) {
                for (int idx : map.get(a)) {
                    array[0] = Math.min(i + 1, idx);
                    array[1] = Math.max(i + 1, idx);
                    if (array[0] != array[1]) {
                        return array;
                    }
                }
            }
        }
        return array;
    }
}
