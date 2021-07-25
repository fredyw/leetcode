package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/
 */
public class Problem1941 {
    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = -1;
        for (int c : map.values()) {
            if (count == -1) {
                count = c;
            } else if (count != c) {
                return false;
            }
        }
        return true;
    }
}
