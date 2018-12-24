package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
 */
public class Problem961 {
    public int repeatedNTimes(int[] A) {
        int n = A.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        for (int a : A) {
            if (!map.containsKey(a)) {
                map.put(a, 1);
            } else {
                map.put(a, map.get(a) + 1);
                if (map.get(a) == n) {
                    answer = a;
                    break;
                }
            }
        }
        return answer;
    }
}
