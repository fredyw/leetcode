package leetcode;

/**
 * https://leetcode.com/problems/valid-palindrome/
 */
public class Problem125 {
    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int x = 0;
        int y = chars.length - 1;
        while (x < y) {
            while (!Character.isLetterOrDigit(chars[x])) {
                x++;
                if (x >= chars.length) {
                    return true;
                }
            }
            while (!Character.isLetterOrDigit(chars[y])) {
                y--;
                if (y < 0) {
                    return true;
                }
            }
            if (chars[x++] != chars[y--]) {
                return false;
            }
        }
        return true;
    }
}
