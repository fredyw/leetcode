package leetcode;

/**
 * https://leetcode.com/problems/reverse-prefix-of-word/
 */
public class Problem2000 {
    public String reversePrefix(String word, char ch) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                String reversed = new StringBuilder(word.substring(0, i + 1)).reverse().toString();
                return reversed + word.substring(i + 1);
            }
        }
        return word;
    }
}
