package leetcode;

/**
 * https://leetcode.com/problems/score-of-parentheses/
 */
public class Problem856 {
    public int scoreOfParentheses(String S) {
        return scoreOfParentheses(S, 0, false);
    }

    private int scoreOfParentheses(String s, int i, boolean open) {
        if (i == s.length()) {
            return 0;
        }
        int result = 0;
        if (s.charAt(i) == '(') {
            if (open) {
                result = scoreOfParentheses(s, i + 1, true);
            } else {
                result = scoreOfParentheses(s, i + 1, true);
            }
        } else { // s.charAt(i) == ')'
            result = scoreOfParentheses(s, i + 1, false) + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Problem856 prob = new Problem856();
//        System.out.println(prob.scoreOfParentheses("()")); // 1
//        System.out.println(prob.scoreOfParentheses("(())")); // 2
//        System.out.println(prob.scoreOfParentheses("()()()")); // 3
//        System.out.println(prob.scoreOfParentheses("(())()")); // 3
//        System.out.println(prob.scoreOfParentheses("()()")); // 2
//        System.out.println(prob.scoreOfParentheses("(()(()))")); // 6
//        System.out.println(prob.scoreOfParentheses("((()))")); // 4
//        System.out.println(prob.scoreOfParentheses("((()()))")); // 8
        System.out.println(prob.scoreOfParentheses("((()())())")); // 10
    }
}
