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
        int removeClose = 0;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.size() > 0) {
                    stack.pop();
                } else {
                    removeClose++;
                }
            }
        }
        int removeOpen = stack.size();
        Set<String> result = new HashSet<>();
        remove(0, s, 0, removeOpen, removeClose, "", result);
        return new ArrayList<>(result);
    }

    private void remove(int idx, String str, int matching, int removeOpen, int removeClose,
                        String accu, Set<String> set) {
        if (idx == str.length()) {
            if (removeOpen == 0 && removeClose == 0 && matching == 0) {
                set.add(accu);
            }
            return;
        }
        char c = str.charAt(idx);
        if (c == '(') {
            // keep
            remove(idx + 1, str, matching + 1, removeOpen, removeClose, accu + c, set);
            if (removeOpen - 1 >= 0) {
                // remove
                remove(idx + 1, str, matching, removeOpen - 1, removeClose, accu, set);
            }
        } else if (c == ')') {
            if (matching - 1 >= 0) {
                // keep
                remove(idx + 1, str, matching - 1, removeOpen, removeClose, accu + c, set);
            }
            if (removeClose - 1 >= 0) {
                // remove
                remove(idx + 1, str, matching, removeOpen, removeClose - 1, accu, set);
            }
        } else {
            remove(idx + 1, str, matching, removeOpen, removeClose, accu + c, set);
        }
    }
}
