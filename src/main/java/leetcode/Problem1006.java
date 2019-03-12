package leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/clumsy-factorial/
 */
public class Problem1006 {
    public int clumsy(int N) {
        char[] ops = new char[]{'*', '/', '+', '-'};
        int opIdx = 0;
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();
        for (int i = N; i >= 1; i--) {
            if (i == N) {
                numbers.add(i);
                continue;
            }
            char op = ops[opIdx];
            while (!operators.isEmpty() &&
                ((op != '*' && op != '/') || (operators.peek() != '+' && operators.peek() != '-'))) {
                numbers.push(apply(numbers.pop(), numbers.pop(), operators.pop()));
            }
            numbers.add(i);
            operators.add(op);
            opIdx = (opIdx + 1) % ops.length;
        }
        while (!operators.isEmpty()) {
            numbers.push(apply(numbers.pop(), numbers.pop(), operators.pop()));
        }
        return numbers.pop();
    }

    private static int apply(int b, int a, char op) {
        if (op == '*') {
            return a * b;
        } else if (op == '/') {
            return a / b;
        } else if (op == '+') {
            return a + b;
        }
        return a - b;
    }
}
