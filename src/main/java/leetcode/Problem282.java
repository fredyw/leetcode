package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/expression-add-operators/
 */
public class Problem282 {
    public List<String> addOperators(String num, int target) {
        List<String> answer = new ArrayList<>();
        Set<String>[] memo = new HashSet[num.length()];
        for (String expr : getExpressions(num, 0, memo)) {
            if (calculate(expr) == target) {
                answer.add(expr);
            }
        }
        return answer;
    }

    private static Set<String> getExpressions(String num, int idx, Set<String>[] memo) {
        if (idx >= num.length()) {
            return new HashSet<>();
        }
        if (memo[idx] != null) {
            return memo[idx];
        }
        Set<String> answer = new HashSet<>();
        char c = num.charAt(idx);
        for (String op : new String[]{"+", "-", "*"}) {
            Set<String> strings = getExpressions(num, idx + 1, memo);
            if (strings.isEmpty()) {
                answer.add("" + c);
            } else {
                for (String s : strings) {
                    answer.add(c + s);
                }
            }
            strings = getExpressions(num, idx + 1, memo);
            if (strings.isEmpty()) {
                answer.add("" + c);
            } else {
                for (String s : strings) {
                    answer.add(c + op + s);
                }
            }
        }
        memo[idx] = answer;
        return answer;
    }

    private static long calculate(String expr) {
        ArrayDeque<Character> operators = new ArrayDeque<>();
        ArrayDeque<Long> operands = new ArrayDeque<>();
        String num = "";
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (Character.isDigit(c)) {
                num += c;
            } else { // the operator
                if (num.length() >= 2 && num.charAt(0) == '0') {
                    return Long.MIN_VALUE;
                }
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
            if (num.length() >= 2 && num.charAt(0) == '0') {
                return Long.MIN_VALUE;
            }
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
        return operands.removeLast();
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
