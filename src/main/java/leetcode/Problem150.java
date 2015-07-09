package leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
public class Problem150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*")
                || token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                if (token.equals("+")) {
                    stack.push(a + b);
                } else if (token.equals("-")) {
                    stack.push(a - b);
                } else if (token.equals("*")) {
                    stack.push(a * b);
                } else { // token.equals("/")
                    stack.push(a / b);
                }
            } else {
                int number = Integer.parseInt(token);
                stack.push(number);
            }
        }
        return stack.pop();
    }
}
