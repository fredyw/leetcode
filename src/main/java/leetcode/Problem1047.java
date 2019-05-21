package leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 */
public class Problem1047 {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (stack.isEmpty()) {
                stack.add(S.charAt(i));
            } else {
                if (stack.peek() == S.charAt(i)) {
                    stack.pop();
                } else {
                    stack.add(S.charAt(i));
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        for (char c : stack) {
            answer.append(c);
        }
        return answer.toString();
    }
}
