package leetcode;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-equivalent-domino-pairs/
 */
public class Problem1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        int answer = 0;
        Map<String, /*count*/ Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < dominoes.length; i++) {
            Arrays.sort(dominoes[i]);
            String key = Arrays.toString(dominoes[i]);
            if (!map.containsKey(key)) {
                map.put(key, 1);
                max = Math.max(max, 1);
            } else {
                int val = map.get(key) + 1;
                map.put(key, val);
                max = Math.max(max, val);
            }
        }
        // 2 ->  1
        // 3 ->  3 (+2)
        // 4 ->  6 (+3)
        // 5 -> 10 (+4)
        // 6 -> 15 (+5)
        // 7 -> 21 (+6)
        // ...
        int[] values = new int[max + 1];
        values[2] = 1;
        for (int i = 3; i <= max; i++) {
            values[i] += i - 1 + values[i - 1];
        }
        for (int count : map.values()) {
            if (count >= 2) {
                answer += values[count];
            }
        }
        return answer;
    }
}
