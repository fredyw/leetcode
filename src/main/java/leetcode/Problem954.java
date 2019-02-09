package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/array-of-doubled-pairs/
 */
public class Problem954 {
    public boolean canReorderDoubled(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            if (!map.containsKey(a)) {
                map.put(a, 1);
            } else {
                map.put(a, map.get(a) + 1);
            }
        }
        while (!map.isEmpty()) {
            Set<Integer> keys = map.keySet();
            if (!keys.isEmpty()) {
                Integer key1 = keys.iterator().next();
                Integer count1 = map.get(key1);
                count1--;
                if (count1 == 0) {
                    map.remove(key1);
                } else {
                    map.put(key1, count1);
                }
                Integer key2 = key1 * 2;
                Integer count2 = map.get(key2);
                if (count2 == null) {
                    if (key1 % 2 != 0) {
                        return false;
                    }
                    key2 = key1 / 2;
                    count2 = map.get(key2);
                    if (count2 == null) {
                        return false;
                    }
                }
                count2--;
                if (count2 == 0) {
                    map.remove(key2);
                } else {
                    map.put(key2, count2);
                }
            }
        }
        return true;
    }
}
