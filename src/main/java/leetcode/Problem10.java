package leetcode;

/**
 * https://leetcode.com/problems/regular-expression-matching/
 */
public class Problem10 {
    public boolean isMatch(String s, String p) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem10 prob = new Problem10();
        System.out.println(prob.isMatch("aa", "a")); // false
        System.out.println(prob.isMatch("aa", "aa")); // true
        System.out.println(prob.isMatch("aaa", "aa")); // false
        System.out.println(prob.isMatch("aa", "a*")); // true
        System.out.println(prob.isMatch("aa", ".*")); // true
        System.out.println(prob.isMatch("ab", ".*")); // true
        System.out.println(prob.isMatch("aab", "c*a*b")); // true
    }
}
