package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/
 */
public class Problem32 {
    public int longestValidParentheses(String s) {
        return longestValidParentheses(s, 0, s.length(), new HashMap<>());
    }

    private static int longestValidParentheses(String s, int i, int j, Map<String, Integer> memo) {
        if (i >= j) {
            return 0;
        }
        String key = i + "|" + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        String sub = s.substring(i, j);
        int max = 0;
        if (isValid(sub)) {
            max = sub.length();
        } else {
            int a = longestValidParentheses(s, i + 1, j, memo);
            int b = 0;
            if (a < sub.length() - 1) {
                b = longestValidParentheses(s, i, j - 1, memo);
            }
            int c = 0;
            if (a < sub.length() - 2 && b < sub.length() - 2) {
                c = longestValidParentheses(s, i + 1, j - 1, memo);
            }
            max = Math.max(a, Math.max(b, c));
        }
        memo.put(key, max);
        return max;
    }

    private static boolean isValid(String sub) {
        int count = 0;
        for (int i = 0; i < sub.length(); i++) {
            char c = sub.charAt(i);
            if (c == '(') {
                count++;
            } else {
                if (count <= 0) {
                    return false;
                }
                count--;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        Problem32 prob = new Problem32();
        System.out.println(prob.longestValidParentheses("(()")); // 2
        System.out.println(prob.longestValidParentheses(")()())")); // 4
        System.out.println(prob.longestValidParentheses("(")); // 0
        System.out.println(prob.longestValidParentheses("()(())")); // 6
        System.out.println(prob.longestValidParentheses("((())))")); // 6
        System.out.println(prob.longestValidParentheses("()(()")); // 2
        System.out.println(prob.longestValidParentheses("()()(()(((()))()))()))))()(())))()(()())()()()))())))())())))(()()()))))()((()(())(())))((()())(()()()((((()(())))))((()()((())(())(()(())))))()()())(())(()())((()())()(((())))()(()()))")); // 96
        System.out.println(prob.longestValidParentheses(")((()()((((()((((())(())(((()((((())(()((())())())(()))))))))))))(())(()())((())))))(((((()))())))(()()))(())))((()()(()()()()())))()(())((())()(())(((()())((())))(())))()())))))())()())())(((()")); // 108
    }
}
