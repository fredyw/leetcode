package leetcode;

/**
 * https://leetcode.com/problems/merge-strings-alternately/
 */
public class Problem1768 {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < Math.min(word1.length(), word2.length()); i++) {
            answer.append(word1.charAt(i));
            answer.append(word2.charAt(i));
        }
        if (word1.length() > word2.length()) {
            answer.append(word1.substring(word2.length()));
        } else if (word1.length() < word2.length()) {
            answer.append(word2.substring(word1.length()));
        }
        return answer.toString();
    }
}
