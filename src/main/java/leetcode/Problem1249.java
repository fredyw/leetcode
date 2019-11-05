package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 */
public class Problem1249 {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> removed = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    removed.add(i);
                }
            }
        }
        for (int index : stack) {
            removed.add(index);
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!removed.contains(i)) {
                answer.append(s.charAt(i));
            }
        }
        return answer.toString();
    }
}
