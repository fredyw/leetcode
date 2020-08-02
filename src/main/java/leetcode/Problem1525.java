package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
 */
public class Problem1525 {
    public int numSplits(String s) {
        int answer = 0;
        Map<Character, Integer> leftMap = new HashMap<>();
        Map<Character, Integer> rightMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            rightMap.put(s.charAt(i), rightMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            rightMap.put(s.charAt(i), rightMap.get(s.charAt(i)) - 1);
            if (rightMap.get(s.charAt(i)) <= 0) {
                rightMap.remove(s.charAt(i));
            }
            leftMap.put(s.charAt(i), leftMap.getOrDefault(s.charAt(i), 0) + 1);
            if (leftMap.size() == rightMap.size()) {
                answer++;
            }
        }
        return answer;
    }
}
