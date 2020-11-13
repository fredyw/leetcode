package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/lexicographically-smallest-string-after-applying-operations/
 */
public class Problem1625 {
    public String findLexSmallestString(String s, int a, int b) {
        StringRef answer = new StringRef();
        findLexSmallestString(s, a, b, new HashSet<>(), answer);
        return answer.val;
    }

    private static class StringRef {
        private String val;
    }

    private static void findLexSmallestString(String s, int a, int b, Set<String> visited,
                                              StringRef minString) {
        if (visited.contains(s)) {
            return;
        }
        visited.add(s);
        char[] chars = s.toCharArray();
        for (int i = 1; i < s.length(); i += 2) {
            chars[i] = (char) (((chars[i] - '0' + a) % 10) + '0');
        }
        String s1 = new String(chars);
        if (minString.val == null || minString.val.compareTo(s1) > 0) {
            minString.val = s1;
        }
        findLexSmallestString(s1, a, b, visited, minString);
        String s2 = s.substring(s.length() - b) + s.substring(0, s.length() - b);
        if (minString.val.compareTo(s2) > 0) {
            minString.val = s2;
        }
        findLexSmallestString(s2, a, b, visited, minString);
    }
}
