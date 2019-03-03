package leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/
 */
public class Problem1003 {
    public boolean isValid(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == 'c') {
                if (stack.size() < 2) {
                    return false;
                }
                char b = stack.pop();
                char a = stack.pop();
                if (b != 'b' || a != 'a') {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
