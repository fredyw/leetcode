package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 */
public class Problem395 {
    public int longestSubstring(String s, int k) {
        return longestSubstring(s, k, 0, s.length(), new HashMap<>());
    }

    private static int longestSubstring(String s, int k, int left, int right,
                                        Map<String, Integer> memo) {
        if (left >= right) {
            return 0;
        }
        String key = left + "|" + right;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        String sub = s.substring(left, right);
        Map<Character, Integer> map = new HashMap<>();
        for (char c : sub.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        boolean valid = true;
        for (int val : map.values()) {
            if (val < k) {
                valid = false;
                break;
            }
        }
        int a = (!valid) ? 0 : sub.length();
        int b = longestSubstring(s, k, left + 1, right, memo);
        int c = longestSubstring(s, k, left, right - 1, memo);
        int d = longestSubstring(s, k, left + 1, right - 1, memo);
        int max = Math.max(a, Math.max(b, Math.max(c, d)));
        memo.put(key, max);
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
    }
}
