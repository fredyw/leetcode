package leetcode;

/**
 * https://leetcode.com/problems/score-of-parentheses/
 */
public class Problem856 {
    public int scoreOfParentheses(String S) {
        return scoreOfParentheses(S, new IntRef());
    }

    private static class IntRef {
        private int index;
    }

    private int scoreOfParentheses(String s, IntRef ref) {
        int result = 0;
        while (ref.index < s.length()) {
            if (s.charAt(ref.index) == '(' && s.charAt(ref.index + 1) == ')') {
                result++;
                ref.index += 2;
            } else if (s.charAt(ref.index) == '(') {
                ref.index++;
                result += 2 * scoreOfParentheses(s, ref);
            } else {
                ref.index++;
                return result;
            }
        }
        return result;
    }
}
