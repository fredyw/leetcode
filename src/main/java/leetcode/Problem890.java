package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-and-replace-pattern/
 */
public class Problem890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        String p = convert(pattern);
        for (String word : words) {
            String w = convert(word);
            if (p.equals(w)) {
                result.add(word);
            }
        }
        return result;
    }

    private static String convert(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            if (chars[c - 'a'] == 0) {
                sb.append(i);
                chars[c - 'a'] = i++;
            } else {
                sb.append(chars[c - 'a']);
            }
        }
        return sb.toString();
    }
}
