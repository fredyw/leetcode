package leetcode;

/**
 * https://leetcode.com/problems/wildcard-matching/
 */
public class Problem44 {
    public boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length() + 1][p.length() + 1];
        return isMatch(s, p, 0, 0, memo);
    }

    private static boolean isMatch(String s, String p, int i, int j, Boolean[][] memo) {
        if (i == s.length() && j == p.length()) {
            return true;
        } else if (i == s.length()) {
            if (p.charAt(j) == '*') {
                return isMatch(s, p, i, j + 1, memo);
            }
            return false;
        } else if (j == p.length()) {
            return false;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        boolean match = false;
        if (p.charAt(j) == '*') {
            match |= isMatch(s, p, i + 1, j, memo);
            match |= isMatch(s, p, i, j + 1, memo);
            match |= isMatch(s, p, i + 1, j + 1, memo);
        } else if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) {
            match = isMatch(s, p, i + 1, j + 1, memo);
        }
        memo[i][j] = match;
        return match;
    }
}
