package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://oj.leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class Problem3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charToIndices = new HashMap<>();
        int maxLength = 0, minIdx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (charToIndices.containsKey(s.charAt(i))) {
                minIdx = Math.max(charToIndices.get(s.charAt(i)) + 1, minIdx);
            }
            maxLength = Math.max(maxLength, i - minIdx + 1);
            charToIndices.put(s.charAt(i), i);
        }
        return maxLength;
    }
}
