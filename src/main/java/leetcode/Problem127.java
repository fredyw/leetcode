package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * https://oj.leetcode.com/problems/word-ladder/
 */
public class Problem127 {
    public int ladderLength(String start, String end, Set<String> dict) {
        dict.add(end);
        Set<String> marked = new HashSet<>();
        // a simple BFS to get the shortest path
        LinkedList<String> queue = new LinkedList<>();
        Map<String, String> paths = new HashMap<>();
        queue.add(start);
        marked.add(start);
        while (!queue.isEmpty()) {
            String str = queue.remove();
            for (int i = 0; i < str.length(); i++) {
                char[] chars = str.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    chars[i] = c;
                    String newString = new String(chars);
                    if (dict.contains(newString) && !marked.contains(newString)) {
                        queue.add(newString);
                        marked.add(newString);
                        paths.put(newString, str);
                    }
                }
            }
        }
        int result = 0;
        String s = paths.get(end);
        if (s == null) {
            return result;
        }
        result++;
        while (!s.equals(start)) {
            result++;
            s = paths.get(s);
        }
        result++;
        return result;
    }
}
