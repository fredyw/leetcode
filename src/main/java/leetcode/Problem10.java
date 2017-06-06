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

    public static void main(String[] args) {
        Problem10 prob = new Problem10();
        System.out.println(prob.isMatch("aa", "a")); // false
        System.out.println(prob.isMatch("aa", "aa")); // true
        System.out.println(prob.isMatch("aaa", "aa")); // false
        System.out.println(prob.isMatch("aa", "a*")); // true
        System.out.println(prob.isMatch("caab", "c.a.")); // true
        System.out.println(prob.isMatch("aab", "c*a*b")); // true
        System.out.println(prob.isMatch("caab", "c*a*b")); // true
        System.out.println(prob.isMatch("aa", ".*")); // true
        System.out.println(prob.isMatch("ab", ".*")); // true
        System.out.println(prob.isMatch("abb", "a.*b")); // true
        System.out.println(prob.isMatch("abb", "a.*b")); // true
        System.out.println(prob.isMatch("abb", "a.*")); // true
        System.out.println(prob.isMatch("aaa", "ab*a")); // false
        System.out.println(prob.isMatch("", "c*c*")); // true
    }
}
