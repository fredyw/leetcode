package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/rabbits-in-forest/
 */
public class Problem781 {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int answer : answers) {
            if (!map.containsKey(answer)) {
                map.put(answer, 1);
            } else {
                map.put(answer, map.get(answer) + 1);
            }
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            result += e.getKey() + 1;
            int count = e.getValue() - e.getKey() - 1;
            while (count > 0) {
                result += e.getKey() + 1;
                count -= e.getKey() + 1;
            }
        }
        return result;
    }
}
