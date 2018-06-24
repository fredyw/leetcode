package leetcode;

/**
 * https://leetcode.com/problems/score-of-parentheses/
 */
public class Problem856 {
    public int scoreOfParentheses(String S) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem856 prob = new Problem856();
        System.out.println(prob.scoreOfParentheses("()")); // 1
        System.out.println(prob.scoreOfParentheses("(())")); // 2
        System.out.println(prob.scoreOfParentheses("()()")); // 2
        System.out.println(prob.scoreOfParentheses("(()(()))")); // 6
    }
}
