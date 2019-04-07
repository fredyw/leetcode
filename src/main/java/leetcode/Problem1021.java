package leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/remove-outermost-parentheses/
 */
public class Problem1021 {
    public String removeOuterParentheses(String S) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        boolean start = true;
        int idx = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                stack.add('(');
                if (start) {
                    idx = i;
                    start = false;
                }
            } else {
                stack.pop();
            }
            if (stack.isEmpty()) {
                start = true;
                answer += S.substring(idx + 1, i);
            }
        }
        return answer;
    }
}
