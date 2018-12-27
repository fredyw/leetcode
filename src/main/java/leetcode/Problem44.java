package leetcode;

/**
 * https://leetcode.com/problems/wildcard-matching/
 */
public class Problem44 {
    public boolean isMatch(String s, String p) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem44 prob = new Problem44();
        System.out.println(prob.isMatch("aa", "a")); // false
        System.out.println(prob.isMatch("aa", "*")); // true
        System.out.println(prob.isMatch("cb", "?a")); // false
        System.out.println(prob.isMatch("adceb", "*a*b")); // true
        System.out.println(prob.isMatch("acdcb", "a*c?b")); // false
        System.out.println(prob.isMatch("acdcb", "a*c?b")); // false
        System.out.println(prob.isMatch("aabc", "a*?c")); // true
    }
}
