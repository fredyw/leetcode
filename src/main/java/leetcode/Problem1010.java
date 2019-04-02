package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 */
public class Problem1010 {
    public int numPairsDivisibleBy60(int[] time) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < time.length; i++) {
            int a = time[i] % 60;
            int b = (60 - a) % 60;
            if (map.containsKey(b)) {
                answer += map.get(b);
            }
            if (!map.containsKey(a)) {
                map.put(a, 1);
            } else {
                map.put(a, map.get(a) + 1);
            }
        }
        return answer;
    }
}
