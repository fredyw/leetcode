package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-lucky-integer-in-an-array/
 */
public class Problem1394 {
    public int findLucky(int[] arr) {
        Map</* number= */ Integer, /* count= */ Integer> map = new HashMap<>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int answer = -1;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getKey() != e.getValue()) {
                continue;
            }
            answer = Math.max(answer, e.getValue());
        }
        return answer;
    }
}
