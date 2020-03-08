package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/increasing-decreasing-string/
 */
public class Problem1370 {
    public String sortString(String s) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        String answer = "";
        boolean asc = true;
        while (map.size() > 0) {
            List<Character> keys = asc ?
                new ArrayList<>(map.keySet()) : new ArrayList<>(map.descendingKeySet());
            for (char key : keys) {
                answer += key;
                int c = map.get(key) - 1;
                if (c == 0) {
                    map.remove(key);
                } else {
                    map.put(key, c);
                }
            }
            asc = !asc;
        }
        return answer;
    }
}
