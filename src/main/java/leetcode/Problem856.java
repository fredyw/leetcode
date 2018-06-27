package leetcode;

/**
 * https://leetcode.com/problems/score-of-parentheses/
 */
public class Problem856 {
    public int scoreOfParentheses(String S) {
        return scoreOfParentheses(S, 0);
    }

    private int scoreOfParentheses(String s, int i) {
        if (i >= s.length()) {
            return 0;
        }
        int result = 0;
        if (s.charAt(i) == '(' && s.charAt(i + 1) == ')') {
            result = 1 + scoreOfParentheses(s, i + 2);
        } else if (s.charAt(i) == '(') {
            result = 2 * scoreOfParentheses(s, i + 1);
        } else {
//            result = scoreOfParentheses(s, i + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        Problem856 prob = new Problem856();
//        System.out.println(prob.scoreOfParentheses("()")); // 1
//        System.out.println(prob.scoreOfParentheses("(())")); // 2
//        System.out.println(prob.scoreOfParentheses("()()()")); // 3
//        System.out.println(prob.scoreOfParentheses("(())()")); // 3
        System.out.println(prob.scoreOfParentheses("(()())()")); // 5
//        System.out.println(prob.scoreOfParentheses("()()")); // 2
//        System.out.println(prob.scoreOfParentheses("(()(()))")); // 6
//        System.out.println(prob.scoreOfParentheses("((()))")); // 4
//        System.out.println(prob.scoreOfParentheses("((()()))")); // 8
//        System.out.println(prob.scoreOfParentheses("((()())())")); // 10
    }
}
