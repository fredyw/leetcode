package leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/make-the-string-great/
 */
public class Problem1544 {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
            if (stack.size() >= 2) {
                char a = stack.pop();
                char b = stack.pop();
                String aStr = "" + a;
                String bStr = "" + b;
                if ((!bStr.equals(bStr.toLowerCase()) || !aStr.equals(bStr.toUpperCase())) &&
                    (!bStr.equals(bStr.toUpperCase()) || !aStr.equals(bStr.toLowerCase()))) {
                    stack.push(b);
                    stack.push(a);
                }
            }
        }
        if (stack.size() >= 2) {
            char a = stack.pop();
            char b = stack.pop();
            String aStr = "" + a;
            String bStr = "" + b;
            if ((!bStr.equals(bStr.toLowerCase()) || !aStr.equals(bStr.toUpperCase())) &&
                (!bStr.equals(bStr.toUpperCase()) || !aStr.equals(bStr.toLowerCase()))) {
                stack.push(b);
                stack.push(a);
            }
        }
        String answer = "";
        for (char c : stack) {
            answer += c;
        }
        return answer;
    }
}
