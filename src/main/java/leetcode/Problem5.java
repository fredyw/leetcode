package leetcode;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class Problem5 {
    public String longestPalindrome(String s) {
        String[][] memo = new String[s.length() + 1][s.length() + 1];
        return longestPalindrome(s, 0, s.length(), memo);
    }

    private static String longestPalindrome(String s, int i, int j, String[][] memo) {
        if (i >= j) {
            return "";
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        String answer = s.substring(i, j);
        if (isPalindrome(answer)) {
            memo[i][j] = answer;
            return answer;
        } else {
            answer = "";
        }
        String a = longestPalindrome(s, i + 1, j, memo);
        String b = longestPalindrome(s, i, j - 1, memo);
        String c = longestPalindrome(s, i + 1, j - 1, memo);
        if (answer.length() < a.length()) {
            answer = a;
        }
        if (answer.length() < b.length()) {
            answer = b;
        }
        if (answer.length() < c.length()) {
            answer = c;
        }
        memo[i][j] = answer;
        return answer;
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
