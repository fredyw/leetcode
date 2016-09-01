package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 */
public class Problem387 {
    public int firstUniqChar(String s) {
        Map<Character, Integer> charCounts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!charCounts.containsKey(s.charAt(i))) {
                charCounts.put(s.charAt(i), 1);
            } else {
                charCounts.put(s.charAt(i), charCounts.get(s.charAt(i)) + 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            int count = charCounts.get(s.charAt(i));
            if (count == 1) {
                return i;
            }
        }
        return -1;
    }
}
