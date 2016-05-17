package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/remove-invalid-parentheses/
 */
public class Problem301 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        // TODO
        return result;
    }

    public static void main(String[] args) {
        Problem301 prob = new Problem301();
        System.out.println(prob.removeInvalidParentheses("()())()"));
        System.out.println(prob.removeInvalidParentheses("(a)())()"));
        System.out.println(prob.removeInvalidParentheses(")("));
    }
}
