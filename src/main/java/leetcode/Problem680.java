package leetcode;

/**
 * https://leetcode.com/problems/valid-palindrome-ii/
 */
public class Problem680 {
    public boolean validPalindrome(String s) {
        boolean found = true;
        int i = 0;
        int j = s.length() - 1;
        for (; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                found = false;
                break;
            }
        }
        if (!found) {
            boolean found1 = true;
            for (int x = i + 1, y = j; x <= y; x++, y--) {
                if (s.charAt(x) != s.charAt(y)) {
                    found1 = false;
                    break;
                }
            }
            boolean found2 = true;
            for (int x = i, y = j - 1; x <= y; x++, y--) {
                if (s.charAt(x) != s.charAt(y)) {
                    found2 = false;
                    break;
                }
            }
            return found1 || found2;
        }
        return true;
    }
}
