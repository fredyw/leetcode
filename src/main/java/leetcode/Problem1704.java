package leetcode;

/**
 * https://leetcode.com/problems/determine-if-string-halves-are-alike/
 */
public class Problem1704 {
    public boolean halvesAreAlike(String s) {
        int leftCount = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            if (isVowel(s.charAt(i))) {
                leftCount++;
            }
        }
        int rightCount = 0;
        for (int i = s.length() / 2; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                rightCount++;
            }
        }
        return leftCount == rightCount;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' ||
            c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
