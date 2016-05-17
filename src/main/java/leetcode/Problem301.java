package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * https://leetcode.com/problems/remove-invalid-parentheses/
 */
public class Problem301 {
    public List<String> removeInvalidParentheses(String s) {
        int numOpen = 0;
        int numClose = 0;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.size() > 0) {
                    stack.pop();
                } else {
                    numClose++;
                }
            }
        }
        numOpen = stack.size();
        Set<String> result = new HashSet<>();
        remove(0, s, 0, numOpen, numClose, "", result);
        return new ArrayList<>(result);
    }

    private void remove(int idx, String str, int pair, int numOpen, int numClose, String accu,
                        Set<String> set) {
        if (idx == str.length()) {
            if (numOpen == 0 && numClose == 0) {
                set.add(accu);
            }
            return;
        }
        char c = str.charAt(idx);
        if (c == '(') {
            // keep
            remove(idx + 1, str, pair + 1, numOpen, numClose, accu + c, set);
            if (numOpen - 1 >= 0) {
                // remove
                remove(idx + 1, str, pair + 1, numOpen - 1, numClose, accu, set);
            }
        } else if (c == ')') {
            // keep
            remove(idx + 1, str, numOpen, pair - 1, numClose, accu + c, set);
            if (numClose - 1 >= 0) {
                // remove
                remove(idx + 1, str, pair - 1, numOpen, numClose - 1, accu, set);
            }
        } else {
            remove(idx + 1, str, numOpen, pair, numClose, accu + c, set);
        }
    }

    public static void main(String[] args) {
        Problem301 prob = new Problem301();
//        System.out.println(prob.removeInvalidParentheses("()())()")); // ()()(), (())()
//        System.out.println(prob.removeInvalidParentheses("(a)())()")); // (a)()(), (a())()
//        System.out.println(prob.removeInvalidParentheses(")(")); //
        System.out.println(prob.removeInvalidParentheses("(()(")); // ()
//        System.out.println(prob.removeInvalidParentheses("))")); //
//        System.out.println(prob.removeInvalidParentheses("((")); //
    }
}
