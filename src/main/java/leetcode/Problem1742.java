package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/maximum-number-of-balls-in-a-box/
 */
public class Problem1742 {
    public int countBalls(int lowLimit, int highLimit) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = 0;
            for (char c : ("" + i + lowLimit).toCharArray()) {
                sum += c - '0';
            }
            int count = map.getOrDefault(sum, 0) + 1;
            map.put(sum, count);
            answer = Math.max(answer, count);
        }
        return answer;
    }
}
