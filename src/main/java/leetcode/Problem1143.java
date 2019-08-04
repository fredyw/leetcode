package leetcode;

/**
 * https://leetcode.com/problems/longest-common-subsequence/
 */
public class Problem1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        return longestCommonSubsequence(text1, text2, 0, 0);
    }

    private static int longestCommonSubsequence(String text1, String text2, int i, int j) {
        if (i == text1.length()) {
            return 0;
        }
        if (j == text2.length()) {
            return 0;
        }
        int value;
        if (text1.charAt(i) == text2.charAt(j)) {
            value = longestCommonSubsequence(text1, text2, i + 1, j + 1) + 1;
        } else {
            value = longestCommonSubsequence(text1, text2, i + 1, j) +
                longestCommonSubsequence(text1, text2, i, j + 1);
        }
        return value;
    }

    public static void main(String[] args) {
        Problem1143 prob = new Problem1143();
        System.out.println(prob.longestCommonSubsequence("abcde", "ace")); // 3
//        System.out.println(prob.longestCommonSubsequence("ace", "abcde")); // 3
//        System.out.println(prob.longestCommonSubsequence("abc", "abc")); // 3
//        System.out.println(prob.longestCommonSubsequence("abc", "def")); // 0
    }
}
