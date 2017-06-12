package leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/add-binary/
 */
public class Problem67 {
    public String addBinary(String a, String b) {
        int diff = Math.abs(a.length() - b.length());
        String zeroes = "";
        for (int i = 0; i < diff; i++) {
            zeroes += "0";
        }
        if (a.length() > b.length()) {
            b = zeroes + b;
        } else if (a.length() < b.length()) {
            a = zeroes + a;
        }
        Stack<Integer> stack = new Stack<>();
        boolean carry = false;
        // by now a's length should be the same as b's length
        for (int i = a.length() - 1; i >= 0; i--) {
            int x = (a.charAt(i) == '1') ? 1 : 0;
            int y = (b.charAt(i) == '1') ? 1 : 0;
            int val = x + y;
            if (carry) {
                val += 1;
            }
            if (val >= 2) {
                stack.push(val % 2);
                carry = true;
            } else {
                stack.push(val);
                carry = false;
            }
        }
        if (carry) {
            stack.push(1);
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }
}
