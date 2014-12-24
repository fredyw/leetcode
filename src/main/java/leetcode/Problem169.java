package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://oj.leetcode.com/problems/majority-element/
 */
public class Problem169 {
    public int majorityElement(int[] num) {
        if (num.length == 1) {
            return num[0];
        }
        int majority = num.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num.length; i++) {
            if (!map.containsKey(num[i])) {
                map.put(num[i], 1);
            } else {
                int count = map.get(num[i]) + 1;
                if (count > majority) {
                    return num[i];
                } else {
                    map.put(num[i], map.get(num[i]) + 1);
                }
            }
        }
        // no answer, but the problem has an assumption that such a value always
        // exists, so this statement can never be reached
        throw new RuntimeException("No majority element found");
    }
}
