package leetcode;

import java.util.ArrayDeque;

/**
 * https://leetcode.com/problems/basic-calculator-ii/
 */
public class Problem227 {
    public int calculate(String s) {
        String expr = s.replaceAll("\\s", "");
        ArrayDeque<Character> operators = new ArrayDeque<>();
        ArrayDeque<Long> operands = new ArrayDeque<>();
        String num = "";
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (Character.isDigit(c)) {
                num += c;
            } else { // the operator
                operands.addLast(Long.valueOf(num));
                if (!operators.isEmpty()) {
                    char op = operators.peekLast();
                    if (op == '*' || op == '/') {
                        long a = operands.removeLast();
                        long b = operands.removeLast();
                        op = operators.removeLast();
                        operands.addLast(evaluate(b, a, op));
                    }
                }
                operators.addLast(c);
                num = "";
            }
        }
        if (!num.isEmpty()) {
            operands.addLast(Long.valueOf(num));
        }
        if (!operators.isEmpty()) {
            char op = operators.peekLast();
            if (op == '*' || op == '/') {
                long a = operands.removeLast();
                long b = operands.removeLast();
                op = operators.removeLast();
                operands.addLast(evaluate(b, a, op));
            }
        }
        // Evaluate from left to right.
        while (!operators.isEmpty()) {
            long a = operands.removeFirst();
            long b = operands.removeFirst();
            char op = operators.removeFirst();
            operands.addFirst(evaluate(a, b, op));
        }
        return operands.removeLast().intValue();
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
