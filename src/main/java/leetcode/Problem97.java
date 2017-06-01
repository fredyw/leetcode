package leetcode;

/**
 * https://leetcode.com/problems/interleaving-string/
 */
public class Problem97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int[][][] memo = new int[s1.length() + 1][s2.length() + 1][s3.length() + 1];
        // -1 -> false
        // 0  -> uninitialized
        // 1  -> true
        return isInterleave(s1, s2, s3, 0, 0, 0, memo);
    }

    private static boolean isInterleave(String s1, String s2, String s3, int i, int j, int k,
                                        int[][][] memo) {
        if (i == s1.length() && j == s2.length() && k == s3.length()) {
            return true;
        }
        if (memo[i][j][k] != 0) {
            return memo[i][j][k] == -1 ? false : true;
        }
        boolean found = false;
        if (i < s1.length()) {
            if (s1.charAt(i) == s3.charAt(k)) {
                found |= isInterleave(s1, s2, s3, i + 1, j, k + 1, memo);
            }
            if (found) {
                return found;
            }
        }
        if (j < s2.length()) {
            if (s2.charAt(j) == s3.charAt(k)) {
                found |= isInterleave(s1, s2, s3, i, j + 1, k + 1, memo);
            }
        }
        memo[i][j][k] = (found) ? 1 : -1;
        return found;
    }
}
