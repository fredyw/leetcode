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
        Map<Character, Integer> weights = new HashMap<>();
        weights.put('/', 2);
        weights.put('*', 2);
        weights.put('-', 1);
        weights.put('+', 1);
        String str = s.replaceAll("\\s+", "");
        Stack<Long> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        String num = "";
        for (char c : str.toCharArray()) {
            System.out.println("processing " + c);
            System.out.println(" - operands: " + operands);
            System.out.println(" - operators: " + operators);
            if (Character.isDigit(c)) {
                num += c;
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                if (!num.isEmpty()) {
                    System.out.println(" - adding " + num);
                    operands.add(Long.parseLong(num));
                    num = "";
                }
                if (!operators.isEmpty()) {
                    int peekOpWeight = weights.get(operators.peek());
                    int weight = weights.get(c);
                    if (peekOpWeight >= weight) {
                        evaluate(operands, operators);
                    }
                }
                System.out.println(" - adding " + c);
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
        System.out.println(operands);
        System.out.println(operators);
        // evaluate from left to right
        Collections.reverse(operands);
        Collections.reverse(operators);
        while (!operators.isEmpty()) {
            evaluateLeftToRight(operands, operators);
        }
        System.out.println(operands);
        System.out.println(operators);
        return (int) operands.pop().longValue();
    }
    
    private void evaluate(Stack<Long> operands, Stack<Character> operators) {
        char op = operators.pop();
        long a = operands.pop();
        long b = operands.pop();
        long val = evaluate(b, a, op);
        System.out.println(" - evaluating " + b + op + a + "=" + val);
        System.out.println(" - adding " + val);
        operands.add(val);
    }
    
    private void evaluateLeftToRight(Stack<Long> operands, Stack<Character> operators) {
        char op = operators.pop();
        long a = operands.pop();
        long b = operands.pop();
        long val = evaluate(a, b, op);
        System.out.println(" - evaluating " + a + op + b + "=" + val);
        System.out.println(" - adding " + val);
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
    
    public static void main(String[] args) {
        Problem227 prob = new Problem227();
//        System.out.println(prob.calculate("3+2*2")); // 7
//        System.out.println(prob.calculate(" 3/2 ")); // 1
//        System.out.println(prob.calculate(" 3+5 / 2 ")); // 5
//        System.out.println(prob.calculate("1*4+5+2-3/6*8")); // 11
//        System.out.println(prob.calculate("0-2147483648")); // -2147483648
//        System.out.println(prob.calculate("530+194/2/2*3/25*2/5*6/5*8-22/2*2*4+24*11+120/6/2/2*13*62")); // 4752
//        System.out.println(prob.calculate("1-1+1")); // 1
//        System.out.println(prob.calculate("14/3*2")); // 8
//        System.out.println(prob.calculate("1*2-3/4+5*6-7*8+9/10")); // -24
        System.out.println(prob.calculate("282-1*2*13-30-2*2*2/2-95/5*2+55+804+3024")); // 4067
//        System.out.println(prob.calculate("282-26-30-4-38+55+804+3024"));
        // (1*2)-(3/4)+(5*6)-(7*8)+(9/10)
    }
}
