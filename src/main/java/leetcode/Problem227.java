package leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/basic-calculator-ii/
 */
public class Problem227 {
    public int calculate(String s) {
        Map<Character, Integer> precendenceMap = new HashMap<>();
        precendenceMap.put('/', 2);
        precendenceMap.put('*', 2);
        precendenceMap.put('-', 1);
        precendenceMap.put('+', 1);
        String str = s.replaceAll("\\s+", "");
        Stack<Long> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        String num = "";
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                num += c;
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                if (!num.isEmpty()) {
                    operands.add(Long.parseLong(num));
                    num = "";
                }
                if (!operators.isEmpty()) {
                    int peekPrecedence = precendenceMap.get(operators.peek());
                    int predence = precendenceMap.get(c);
                    if (peekPrecedence >= predence) {
                        evaluate(operands, operators);
                    }
                }
                if (c == '+' || c == '-') {
                    while (!operators.isEmpty()) {
                        evaluate(operands, operators);
                    }
                }
                operators.add(c);
            }
        }
        if (!num.isEmpty()) {
            operands.add(Long.parseLong(num));
            num = "";
        }
        if (!operators.isEmpty()) {
            evaluate(operands, operators);
        }
        // evaluate from left to right
        Collections.reverse(operands);
        Collections.reverse(operators);
        while (!operators.isEmpty()) {
            evaluateLeftToRight(operands, operators);
        }
        return (int) operands.pop().longValue();
    }
    
    private void evaluate(Stack<Long> operands, Stack<Character> operators) {
        char op = operators.pop();
        long a = operands.pop();
        long b = operands.pop();
        long val = evaluate(b, a, op);
        operands.add(val);
    }
    
    private void evaluateLeftToRight(Stack<Long> operands, Stack<Character> operators) {
        char op = operators.pop();
        long a = operands.pop();
        long b = operands.pop();
        long val = evaluate(a, b, op);
        operands.add(val);
    }
    
    private long evaluate(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else { // op == /
            return a / b;
        }
    }
}
