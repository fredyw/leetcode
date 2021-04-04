package leetcode;

/**
 * https://leetcode.com/problems/truncate-sentence/
 */
public class Problem1816 {
    public String truncateSentence(String s, int k) {
        String[] words = s.split("\\s");
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < k; i++) {
            if (i > 0) {
                answer.append(" ");
            }
            answer.append(words[i]);
        }
        return answer.toString();
    }
}
