package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/
 */
public class Problem2006 {
    public int countKDifference(int[] nums, int k) {
        Map</* num */ Integer, /* count */ Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int answer = 0;
        for (int num : map.keySet()) {
            int a = num - k;
            if (map.containsKey(a)) {
                answer += map.get(num) * map.get(a);
            }
        }
        return answer;
    }
}
