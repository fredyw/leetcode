package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/occurrences-after-bigram/
 */
public class Problem1078 {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> answer = new ArrayList<>();
        String[] words = text.split("\\s");
        int i = 0;
        while (i < words.length - 1) {
            if (words[i].equals(first) && words[i + 1].equals(second)) {
                if (i + 2 < words.length) {
                    answer.add(words[i + 2]);
                }
            }
            i++;
        }
        return answer.toArray(new String[0]);
    }
}
