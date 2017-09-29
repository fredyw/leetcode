package leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parenthesis-string/
 */
public class Problem678 {
    public boolean checkValidString(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '*') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (stack.peek() == '(' || stack.peek() == '*') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (stack.size() % 2 != 0) {
            return false;
        }
        while (!stack.isEmpty()) {
            char a = stack.pop();
            char b = stack.pop();
            if (a == '(' || b == ')') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem678 prob = new Problem678();
        System.out.println(prob.checkValidString("()")); // true
        System.out.println(prob.checkValidString("(*)")); // true
//        System.out.println(prob.checkValidString("(*))")); // true
//        System.out.println(prob.checkValidString(")(")); // false
//        System.out.println(prob.checkValidString("()()")); // true
//        System.out.println(prob.checkValidString("(**())")); // true
    }
}
