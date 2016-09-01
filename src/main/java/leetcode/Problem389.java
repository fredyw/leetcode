package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-the-difference/
 */
public class Problem389 {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> charCounts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!charCounts.containsKey(s.charAt(i))) {
                charCounts.put(s.charAt(i), 1);
            } else {
                charCounts.put(s.charAt(i), charCounts.get(s.charAt(i)) + 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (!charCounts.containsKey(t.charAt(i))) {
                return t.charAt(i);
            } else {
                int count = charCounts.get(t.charAt(i)) - 1;
                if (count == 0) {
                    charCounts.remove(t.charAt(i));
                } else {
                    charCounts.put(t.charAt(i), count);
                }
            }
        }
        throw new RuntimeException("Should not happen");
    }
}
