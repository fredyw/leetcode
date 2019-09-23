package leetcode;

/**
 * https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 */
public class Problem1190 {
    public String reverseParentheses(String s) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1190 prob = new Problem1190();
        System.out.println(prob.reverseParentheses("(abcd)")); // "dcba"
        System.out.println(prob.reverseParentheses("(u(love)i)")); // "iloveu"
        System.out.println(prob.reverseParentheses("(ed(et(oc))el)")); // "leetcode"
        System.out.println(prob.reverseParentheses("a(bcdefghijkl(mno)p)q")); // "apmnolkjihgfedcbq"
    }
}
