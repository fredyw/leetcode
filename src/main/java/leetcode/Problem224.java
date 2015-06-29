package leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/basic-calculator/
 */
public class Problem224 {
    public int calculate(String s) {
        String str = s.replaceAll("\\s+", "");
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        String num = "";
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                num += c;
            } else if (c == '+' || c == '-') {
                if (!num.isEmpty()) {
                    operands.add(Integer.parseInt(num));
                    num = "";
                }
                if (!operators.isEmpty()) {
                    evaluate(operands, operators);
                }
                operators.add(c);
            } else if (c == '(') {
                operators.add(c);
            } else if (c == ')') {
                if (!num.isEmpty()) {
                    operands.add(Integer.parseInt(num));
                    num = "";
                }
                if (!operators.isEmpty()) {
                    evaluate(operands, operators);
                }
            }
        }
        if (!num.isEmpty()) {
            operands.add(Integer.parseInt(num));
            num = "";
        }
        if (!operators.isEmpty()) {
            evaluate(operands, operators);
        }
        return operands.pop();
    }
    
    private void evaluate(Stack<Integer> operands, Stack<Character> operators) {
        char op = operators.pop();
        if (op == '(') {
            return;
        }
        int a = operands.pop();
        int b = operands.pop();
        int val = evaluate(b, a, op);
        operands.add(val);
    }
    
    private int evaluate(int a, int b, char op) {
        if (op == '+') {
            return a + b;
        } else { // op == '-'
            return a - b;
        }
    }
}
