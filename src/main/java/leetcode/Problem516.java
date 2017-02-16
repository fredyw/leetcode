package leetcode;

/**
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 */
public class Problem516 {
    public int longestPalindromeSubseq(String s) {
        Integer[][] memo = new Integer[s.length()][s.length()];
        return longestPalindromSubsequence(s, 0, s.length() - 1, memo);
    }

    private static int longestPalindromSubsequence(String str, int i, int j,
                                                   Integer[][] memo) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        int max = 0;
        if (str.charAt(i) == str.charAt(j)) {
            max = 2 + longestPalindromSubsequence(str, i + 1, j - 1, memo);
        } else {
            max = Math.max(
                longestPalindromSubsequence(str, i + 1, j, memo),
                longestPalindromSubsequence(str, i, j - 1, memo));
        }
        memo[i][j] = max;
        return max;
    }
}
