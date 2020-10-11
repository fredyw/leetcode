package leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
 */
public class Problem1614 {
    public int maxDepth(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.add('(');
            } else if (c == ')') {
                stack.pop();
            }
            answer = Math.max(answer, stack.size());
        }
        return answer;
    }
}
