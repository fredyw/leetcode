package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/generate-parentheses/
 */
public class Problem22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n > 0) {
            generateParenthesis(n, 0, 0, "", result);
        }
        return result;
    }

    private void generateParenthesis(int n, int open, int close,
                                     String accu, List<String> result) {
        if (close == n) {
            result.add(accu);
            return;
        }
        if (open > close) {
            generateParenthesis(n, open, close + 1, accu + ")", result);
        }
        if (open < n) {
            generateParenthesis(n, open + 1, close, accu + "(", result);
        }
    }
}
