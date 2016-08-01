package leetcode;

import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/plus-one/
 */
public class Problem66 {
    public int[] plusOne(int[] digits) {
        Stack<Integer> stack = new Stack<>();
        boolean carry = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            int val = digits[i];
            if (i == digits.length - 1) {
                val += 1;
            }
            if (carry) {
                val += 1;
            }
            if (val >= 10) {
                stack.push(val % 10);
                carry = true;
            } else {
                stack.push(val);
                carry = false;
            }
        }
        if (carry) {
            stack.push(1);
        }
        int[] result = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            result[i] = stack.pop();
            i++;
        }
        return result;
    }
}
