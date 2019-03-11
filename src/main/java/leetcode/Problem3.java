package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class Problem3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int answer = 0;
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                idx = Math.max(map.get(c) + 1, idx);
            }
            answer = Math.max(answer, i - idx + 1);
            map.put(c, i);
        }
        return answer;
    }
}
