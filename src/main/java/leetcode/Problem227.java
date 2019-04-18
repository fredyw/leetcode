package leetcode;

import java.util.Collections;
import java.util.Stack;

/**
 * https://leetcode.com/problems/basic-calculator-ii/
 */
public class Problem227 {
    public int calculate(String s) {
        String expr = s.replaceAll("\\s", "");
        Stack<Character> operators = new Stack<>();
        Stack<Long> operands = new Stack<>();
        String num = "";
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (Character.isDigit(c)) {
                num += c;
            } else { // the operator
                operands.add(Long.valueOf(num));
                if (!operators.isEmpty()) {
                    char op = operators.peek();
                    if (op == '*' || op == '/') {
                        long a = operands.pop();
                        long b = operands.pop();
                        op = operators.pop();
                        operands.add(evaluate(b, a, op));
                    }
                }
                operators.add(c);
                num = "";
            }
        }
        if (!num.isEmpty()) {
            operands.add(Long.valueOf(num));
        }
        if (!operators.isEmpty()) {
            char op = operators.peek();
            if (op == '*' || op == '/') {
                long a = operands.pop();
                long b = operands.pop();
                op = operators.pop();
                operands.add(evaluate(b, a, op));
            }
        }
        // Evaluate from left to right.
        Collections.reverse(operands);
        Collections.reverse(operators);
        while (!operators.isEmpty()) {
            long a = operands.pop();
            long b = operands.pop();
            char op = operators.pop();
            operands.add(evaluate(a, b, op));
        }
        return operands.pop().intValue();
    }

    private static long evaluate(long a, long b, char op) {
        if (op == '*') {
            return a * b;
        }
        if (op == '/') {
            return a / b;
        }
        if (op == '+') {
            return a + b;
        }
        return a - b; // op == '-'
    }
}
