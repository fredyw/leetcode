package leetcode;

/**
 * https://leetcode.com/problems/regular-expression-matching/
 */
public class Problem10 {
    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0);
    }

    private static boolean isMatch(String s, String p, int i, int j) {
        if ((i == s.length() && j == p.length()) ||
            (i == s.length() && j + 2 == p.length() && p.charAt(j + 1) == '*')) {
            return true;
        }
        if (j >= p.length()) {
            return false;
        }
        boolean match = false;
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            if (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
                match |= isMatch(s, p, i + 1, j);
            }
            match |= isMatch(s, p, i, j + 2);
        } else {
            if (i < s.length() && s.charAt(i) != p.charAt(j) && p.charAt(j) != '.') {
                return false;
            }
            match |= isMatch(s, p, i + 1, j + 1);
        }
        return match;
    }
}
