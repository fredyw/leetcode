package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-good-pairs/
 */
public class Problem1512 {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int answer = 0;
        for (int count : map.values()) {
            for (int i = 1; i < count; i++) {
                answer += i;
            }
        }
        return answer;
    }
}
