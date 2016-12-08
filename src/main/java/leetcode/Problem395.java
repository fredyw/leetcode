package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 */
public class Problem395 {
    public int longestSubstring(String s, int k) {
        int max = 0;
        if (k > s.length()) {
            return max;
        }
        for (int i = 0; i < s.length(); i++) {
            int len = 0;
            Map<Character, Integer> map = new HashMap<>();
            if (max >= s.length() - i) {
                break;
            }
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                len++;
                if (!map.containsKey(c)) {
                    map.put(c, 1);
                } else {
                    map.put(c, map.get(c) + 1);
                }
                boolean valid = true;
                for (int val : map.values()) {
                    if (val < k) {
                        valid = false;g
                        break;
                    }
                }
                if (valid) {
                    max = Math.max(max, len);
                }
            }
        }
        return max;
    }
}
