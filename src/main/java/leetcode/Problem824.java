package leetcode;

/**
 * https://leetcode.com/problems/goat-latin/
 */
public class Problem824 {
    public String toGoatLatin(String S) {
        StringBuilder result = new StringBuilder();
        String[] words = S.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (i > 0) {
                result.append(" ");
            }
            if (isVowel(word.charAt(0)) || word.length() == 1) {
                result.append(word);
            } else {
                result.append(word.substring(1)).append(word.charAt(0));
            }
            result.append("ma");
            for (int j = 0; j <= i; j++) {
                result.append("a");
            }
        }
        return result.toString();
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'i' || c == 'u' || c == 'e' || c == 'o' ||
            c == 'A' || c == 'I' || c == 'U' || c == 'E' || c == 'O';
    }
}
