package leetcode;

/**
 * https://leetcode.com/problems/wildcard-matching/
 */
public class Problem44 {
    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0);
    }

    private static boolean isMatch(String s, String p, int i, int j) {
        if (i == s.length() && j == p.length()) {
            return true;
        } else if (i == s.length()) {
            return false;
        } else if (j == p.length()) {
            return false;
        }
        boolean match = false;
        if (p.charAt(j) == '*') {
            match |= isMatch(s, p, i + 1, j);
            match |= isMatch(s, p, i, j + 1);
            match |= isMatch(s, p, i + 1, j + 1);
        } else if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) {
            match = isMatch(s, p, i + 1, j + 1);
        }
        return match;
    }

    public static void main(String[] args) {
        Problem44 prob = new Problem44();
//        System.out.println(prob.isMatch("aa", "a")); // false
//        System.out.println(prob.isMatch("aa", "*")); // true
//        System.out.println(prob.isMatch("cb", "?a")); // false
//        System.out.println(prob.isMatch("adceb", "*a*b")); // true
//        System.out.println(prob.isMatch("acdcb", "a*c?b")); // false
//        System.out.println(prob.isMatch("acdcb", "a*c?b")); // false
//        System.out.println(prob.isMatch("aabc", "a*?c")); // true
        System.out.println(prob.isMatch("abc", "*abc*")); // true
//        System.out.println(prob.isMatch("abc", "*")); // true
//        System.out.println(prob.isMatch("a", "***")); // true
//        System.out.println(prob.isMatch("abc", "abcd")); // false
    }
}
