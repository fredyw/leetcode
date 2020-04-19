package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/construct-k-palindrome-strings/
 */
public class Problem1400 {
    public boolean canConstruct(String s, int k) {
        if (k > s.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int oddCount = 0;
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() % 2 != 0) {
                oddCount++;
            }
        }
        return oddCount <= k;
    }
}
