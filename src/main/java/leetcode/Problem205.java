package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/isomorphic-strings/
 */
public class Problem205 {
    public boolean isIsomorphic(String s, String t) {
        return transform(s).equals(transform(t));
    }
    
    private String transform(String s) {
        StringBuilder str = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        int counter = 0;
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                str.append(map.get(c));
            } else {
                str.append(++counter);
                map.put(c, counter);
            }
        }
        return str.toString();
    }
}
