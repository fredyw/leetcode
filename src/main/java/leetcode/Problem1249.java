package leetcode;

/**
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 */
public class Problem1249 {
    public String minRemoveToMakeValid(String s) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1249 prob = new Problem1249();
        System.out.println(prob.minRemoveToMakeValid("lee(t(c)o)de)")); //  "lee(t(c)o)de"
        System.out.println(prob.minRemoveToMakeValid("a)b(c)d")); //  "ab(c)d"
        System.out.println(prob.minRemoveToMakeValid("))((")); //  "ab(c)d"
        System.out.println(prob.minRemoveToMakeValid("(a(b(c)d)")); //  "a(b(c)d)"
    }
}
