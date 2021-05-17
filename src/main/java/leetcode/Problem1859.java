package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sorting-the-sentence/
 */
public class Problem1859 {
    public String sortSentence(String s) {
        String[] words = s.split(" ");
        Arrays.sort(words, (a, b) -> {
            int index1 = a.charAt(a.length() - 1) - '0';
            int index2 = b.charAt(b.length() - 1) - '0';
            return Integer.compare(index1, index2);
        });
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i > 0) {
                answer.append(" ");
            }
            answer.append(words[i].substring(0, words[i].length() - 1));
        }
        return answer.toString();
    }
}
