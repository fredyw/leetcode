package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/count-largest-group/
 */
public class Problem1399 {
    public int countLargestGroup(int n) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String s = Integer.toString(i);
            int sum = 0;
            for (int j = 0; j < s.length(); j++) {
                sum += s.charAt(j) - '0';
            }
            int newCount = map.getOrDefault(sum, 0) + 1;
            map.put(sum, newCount);
            max = Math.max(max, newCount);
        }
        int answer = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() == max) {
                answer++;
            }
        }
        return answer;
    }
}
