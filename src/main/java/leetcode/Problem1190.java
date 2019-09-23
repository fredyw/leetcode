package leetcode;

/**
 * https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 */
public class Problem1190 {
    public String reverseParentheses(String s) {
        return reverseParentheses(s, new IntRef());
    }

    private static class IntRef {
        private int val;
    }

    private static String reverseParentheses(String s, IntRef index) {
        String str = "";
        while(index.val < s.length()) {
            int i = index.val;
            if (s.charAt(i) == '(') {
                index.val++;
                str += reverseParentheses(s, index);
            } else if (s.charAt(i) == ')') {
                index.val++;
                return new StringBuilder(str).reverse().toString();
            } else {
                str += s.charAt(i);
                index.val++;
            }
        }
        return str;
    }
}
