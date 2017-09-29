package leetcode;

/**
 * https://leetcode.com/problems/valid-parenthesis-string/
 */
public class Problem678 {
    public boolean checkValidString(String s) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem678 prob = new Problem678();
        System.out.println(prob.checkValidString("()")); // true
        System.out.println(prob.checkValidString("(*)")); // true
        System.out.println(prob.checkValidString("(*))")); // true
        System.out.println(prob.checkValidString(")(")); // false
        System.out.println(prob.checkValidString("()()")); // true
    }
}
