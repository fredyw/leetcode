package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/
 */
public class Problem32 {
    public int longestValidParentheses(String s) {
        return longestValidParentheses(s, 0, 0, 0, 0, new HashMap<>()) * 2;
    }

    private static int longestValidParentheses(String s, int idx, int begin, int end,
                                               int accu, Map<String, Integer> memo) {
        if (idx >= s.length()) {
            return accu;
        }
        String key = idx + "|" + begin + "|" + end;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int c = s.charAt(idx);
        int newBegin = begin;
        int newEnd = end;
        if (c == '(') {
            newBegin++;
        } else { // c == ')'
            newEnd++;
        }
        int a = longestValidParentheses(s, idx + 1, begin, end, accu, memo); // skip
        int b = 0;
        if (newBegin >= newEnd) {
            int newAccu = newEnd;
            b = longestValidParentheses(s, idx + 1, newBegin, newEnd, newAccu, memo);
        }
        int max = Math.max(a, b);
        memo.put(key, max);
        return max;
    }

    public static void main(String[] args) {
        Problem32 prob = new Problem32();
        System.out.println(prob.longestValidParentheses("(()")); // 2
        System.out.println(prob.longestValidParentheses(")()())")); // 4
        System.out.println(prob.longestValidParentheses("(")); // 0
        System.out.println(prob.longestValidParentheses("()(())")); // 6
        System.out.println(prob.longestValidParentheses("((())))")); // 6
        System.out.println(prob.longestValidParentheses("()(()")); // 2
    }
}
