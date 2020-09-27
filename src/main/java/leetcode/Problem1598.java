package leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/crawler-log-folder/
 */
public class Problem1598 {
    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
        for (String log : logs) {
            if (log.equals("../")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (log.equals("./")) {
                // Do nothing.
            } else {
                stack.add(log);
            }
        }
        return stack.isEmpty() ? 0 : stack.size();
    }
}
