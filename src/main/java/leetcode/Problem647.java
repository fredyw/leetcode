package leetcode;

/**
 * https://leetcode.com/problems/palindromic-substrings/
 */
public class Problem647 {
    public int countSubstrings(String s) {
        return countSubstrings(s, 0, s.length(), new boolean[s.length() + 1][s.length() + 1]);
    }

    private static int countSubstrings(String s, int i, int j, boolean[][] processed) {
        if (i >= j) {
            return 0;
        }
        if (processed[i][j]) {
            return 0;
        }
        String sub = s.substring(i, j);
        int count = 0;
        if (isPalindrome(sub)) {
            count++;
        }
        int a = countSubstrings(s, i + 1, j, processed);
        int b = countSubstrings(s, i, j - 1, processed);
        count += a + b;
        processed[i][j] = true;
        return count;
    }

    private static boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
