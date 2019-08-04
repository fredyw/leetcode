package leetcode;

/**
 * https://leetcode.com/problems/longest-common-subsequence/
 */
public class Problem1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1143 prob = new Problem1143();
        System.out.println(prob.longestCommonSubsequence("abcde", "ace")); // 3
        System.out.println(prob.longestCommonSubsequence("ace", "abcde")); // 3
        System.out.println(prob.longestCommonSubsequence("abc", "abc")); // 3
        System.out.println(prob.longestCommonSubsequence("abc", "def")); // 0
    }
}
