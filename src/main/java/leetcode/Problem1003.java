package leetcode;

/**
 * https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/
 */
public class Problem1003 {
    public boolean isValid(String S) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem1003 prob = new Problem1003();
        System.out.println(prob.isValid("aabcbc")); // true
        System.out.println(prob.isValid("abcabcababcc")); // true
        System.out.println(prob.isValid("abccba")); // false
        System.out.println(prob.isValid("cababc")); // false
    }
}
