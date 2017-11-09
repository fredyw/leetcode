package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/remove-comments/
 */
public class Problem722 {
    public List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<>();
        boolean skip = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < source.length; i++) {
            String src = source[i];
            int j = 0;
            outer:
            for (; j < src.length(); j++) {
                if (j + 1 < src.length() && src.charAt(j) == '/') {
                    if (!skip && src.charAt(j + 1) == '/') {
                        skip = false;
                        break outer;
                    } else if (!skip && src.charAt(j + 1) == '*') {
                        skip = true;
                        j++;
                        continue;
                    }
                } else if (j + 1 < src.length() && src.charAt(j) == '*') {
                    if (skip && src.charAt(j + 1) == '/') {
                        skip = false;
                        j++;
                        continue;
                    }
                }
                if (!skip && j < src.length()) {
                    sb.append(src.charAt(j));
                }
            }
            if (sb.length() > 0 && !skip) {
                result.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return result;
    }
}
