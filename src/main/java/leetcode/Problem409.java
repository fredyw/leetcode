package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-palindrome/
 */
public class Problem409 {
    public int longestPalindrome(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!charCount.containsKey(c)) {
                charCount.put(c, 1);
            } else {
                charCount.put(c, charCount.get(c) + 1);
            }
        }
        int result = 0;
        boolean hasOdd = false;
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                hasOdd = true;
            }
            result += (entry.getValue() / 2) * 2;
        }
        if (hasOdd) {
            result++;
        }
        return result;
    }
}
