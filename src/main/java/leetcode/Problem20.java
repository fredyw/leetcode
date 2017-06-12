package leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
public class Problem20 {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char openChar = stack.pop();
                if (openChar != '{') {
                    return false;
                }
            } else if (c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char openChar = stack.pop();
                if (openChar != '[') {
                    return false;
                }
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                char openChar = stack.pop();
                if (openChar != '(') {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
