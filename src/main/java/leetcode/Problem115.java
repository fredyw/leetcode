package leetcode;

/**
 * https://leetcode.com/problems/distinct-subsequences/
 */
public class Problem115 {
    public int numDistinct(String s, String t) {
        int[][] memo = new int[s.length()][t.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                memo[i][j] = -1;
            }
        }
        return numDistinct(s, t, 0, 0, memo);
    }

    private static int numDistinct(String s, String t, int i, int j, int[][] memo) {
        if (j >= t.length()) {
            return 1;
        }
        if (i >= s.length() || i < j) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int result = 0;
        for (int x = i; x < s.length(); x++) {
            if (s.charAt(x) == t.charAt(j)) {
                result += numDistinct(s, t, x + 1, j + 1, memo);
            }
        }
        memo[i][j] = result;
        return result;
    }
}
