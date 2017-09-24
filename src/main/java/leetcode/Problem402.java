package leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/remove-k-digits/
 */
public class Problem402 {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        int count = k;
        for (int i = 0; i < num.length(); i++) {
            Integer n = Integer.valueOf(num.charAt(i) - '0');
            if (!stack.isEmpty() && n < stack.peek() && count > 0) {
                while (!stack.isEmpty() && n < stack.peek() && count > 0) {
                    stack.pop();
                    count--;
                }
            }
            stack.push(n);
        }
        while (count > 0) {
            stack.pop();
            count--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        String result = sb.reverse().toString();
        if (result.isEmpty()) {
            return "0";
        }
        // Remove leading zeros.
        int i = 0;
        while (i < result.length() && result.charAt(i++) == '0') {
        }
        return result.substring(i - 1);
    }
}
