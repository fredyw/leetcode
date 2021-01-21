package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/max-number-of-k-sum-pairs/
 */
public class Problem1679 {
    public int maxOperations(int[] nums, int k) {
        Map</* value */ Integer, /* count */ Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int answer = 0;
        for (int a : nums) {
            int countA = map.getOrDefault(a, 0);
            if (countA == 0) {
                continue;
            }
            int b = k - a;
            int countB = map.getOrDefault(b, 0);
            if (a == b) {
                if (countB > 1) {
                    update(map, a);
                    update(map, b);
                    answer++;
                }
            } else {
                if (countB > 0) {
                    update(map, a);
                    update(map, b);
                    answer++;
                }
            }
        }
        return answer;
    }

    private static void update(Map<Integer, Integer> map, int val) {
        int count = map.getOrDefault(val, 0);
        if (count == 0) {
            return;
        }
        if (count - 1 == 0) {
            map.remove(val);
        } else {
            map.put(val, count - 1);
        }
    }
}
