package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

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

    public static void main(String[] args) {
        Problem282 prob = new Problem282();
        System.out.println(prob.addOperators("123", 6)); // ["1+2+3", "1*2*3"]
        System.out.println(prob.addOperators("123", 123)); // ["123"]
        System.out.println(prob.addOperators("232", 8)); // ["2*3+2", "2+3*2"]
        System.out.println(prob.addOperators("105", 5)); // ["1*0+5","10-5"]
        System.out.println(prob.addOperators("00", 0)); // ["0+0", "0-0", "0*0"]
        System.out.println(prob.addOperators("3456237490", 9191)); // []
    }
}
