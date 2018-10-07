package leetcode;

/**
 * https://leetcode.com/problems/reverse-only-letters/
 */
public class Problem917 {
    public String reverseOnlyLetters(String S) {
        int i = 0;
        int j = S.length() - 1;
        char[] chars = S.toCharArray();
        while (i < j) {
            while (i < S.length() && !isLetter(chars[i])) {
                i++;
            }
            while (j >= 0 && !isLetter(chars[j])) {
                j--;
            }
            if (i < j) {
                swap(chars, i++, j--);
            }
        }
        return new String(chars);
    }

    private static boolean isLetter(char c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
    }

    private static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
