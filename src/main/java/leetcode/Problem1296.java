package leetcode;

import java.util.TreeMap;

/**
 * https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
 */
public class Problem1296 {
    public boolean isPossibleDivide(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        while (!map.isEmpty()) {
            Integer key = map.firstKey();
            for (int i = key; i < key + k; i++) {
                if (!map.containsKey(i)) {
                    return false;
                } else {
                    int count = map.get(i) - 1;
                    if (count == 0) {
                        map.remove(i);
                    } else {
                        map.put(i, count);
                    }
                }
            }
        }
        return true;
    }
}
