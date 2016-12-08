package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 */
public class Problem395 {
    public int longestSubstring(String s, int k) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            String sub = "";
            Map<Character, Integer> map = new HashMap<>();
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                sub += c;
                if (!map.containsKey(c)) {
                    map.put(c, 1);
                } else {
                    map.put(c, map.get(c) + 1);
                }
                boolean valid = true;
                for (int val : map.values()) {
                    if (val < k) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    max = Math.max(max, sub.length());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Problem395 prob = new Problem395();
        System.out.println(prob.longestSubstring("aaabb", 3)); // 3
        System.out.println(prob.longestSubstring("ababbc", 2)); // 5
        System.out.println(prob.longestSubstring("aaabcb", 3)); // 3
        System.out.println(prob.longestSubstring("aaabcbc", 2)); // 7
        System.out.println(prob.longestSubstring("aadabcbc", 2)); // 4
        System.out.println(prob.longestSubstring("aadabcbcd", 2)); // 9
        System.out.println(prob.longestSubstring("aadabdbbdc", 2)); // 9
        System.out.println(prob.longestSubstring("bababababababababababababababababaabababababaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbcbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 30)); // 216
    }
}
