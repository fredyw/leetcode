package leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/validate-stack-sequences/
 */
public class Problem946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0 || popped.length == 0) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        int pushIdx = 0;
        int popIdx = 0;
        stack.push(pushed[pushIdx++]);
        while (pushIdx < pushed.length && popIdx < popped.length) {
            if (!stack.isEmpty() && stack.peek() == popped[popIdx]) {
                popIdx++;
                stack.pop();
            } else {
                stack.push(pushed[pushIdx++]);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() != popped[popIdx]) {
                return false;
            }
            popIdx++;
            stack.pop();
        }
        return true;
    }
}
