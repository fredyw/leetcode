package leetcode;

/**
 * https://leetcode.com/problems/longest-common-subsequence/
 */
public class Problem1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        return longestCommonSubsequence(text1, text2, 0, 0, new Integer[text1.length()][text2.length()]);
    }

    private static int longestCommonSubsequence(String text1, String text2, int i, int j, Integer[][] memo) {
        if (i == text1.length()) {
            return 0;
        }
        if (j == text2.length()) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        int value;
        if (text1.charAt(i) == text2.charAt(j)) {
            value = longestCommonSubsequence(text1, text2, i + 1, j + 1, memo) + 1;
        } else {
            value = Math.max(longestCommonSubsequence(text1, text2, i + 1, j, memo),
                longestCommonSubsequence(text1, text2, i, j + 1, memo));
        }
        memo[i][j] = value;
        return value;
    }
}
