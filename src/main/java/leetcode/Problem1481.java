package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
 */
public class Problem1481 {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> sorted = new ArrayList<>(map.entrySet());
        sorted.sort(Comparator.comparingInt(Map.Entry::getValue));
        int i = k;
        int j = 0;
        while (i > 0) {
            Map.Entry<Integer, Integer> entry = sorted.get(j);
            if (i >= entry.getValue()) {
                map.remove(entry.getKey());
                i -= entry.getValue();
            } else {
                int newCount = entry.getValue() - i;
                map.put(entry.getKey(), newCount);
                break;
            }
            j++;
        }
        return map.size();
    }
}
