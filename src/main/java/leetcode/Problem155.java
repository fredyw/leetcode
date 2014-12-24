package leetcode;

import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/min-stack/
 */
public class Problem155 {
    public static class MinStack {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();
        
        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty()) {
                minStack.push(x);
            } else {
                if (minStack.peek().intValue() >= x) {
                    minStack.push(x);
                }
            }
        }

        public void pop() {
            int i = stack.pop().intValue();
            if (i == minStack.peek()) {
                minStack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
