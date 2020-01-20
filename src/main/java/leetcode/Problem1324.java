package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/print-words-vertically/
 */
public class Problem1324 {
    public List<String> printVertically(String s) {
        String[] words = s.split(" ");
        int maxLength = 0;
        for (String word : words) {
            maxLength = Math.max(maxLength, word.length());
        }
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < maxLength; i++) {
            String str = "";
            for (String word : words) {
                if (i >= word.length()) {
                    str += " ";
                } else {
                    str += word.charAt(i);
                }
            }
            answer.add(str.replaceFirst("\\s++$", ""));
        }
        return answer;
    }
}
