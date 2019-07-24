package leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/
 */
public class Problem1111 {
    public int[] maxDepthAfterSplit(String seq) {
        int[] answer = new int[seq.length()];
        int level = 0;
        int max = 0;
        Stack<Integer> startIndexes = new Stack<>();
        // index: start index
        // value: end index
        Integer[] indexes = new Integer[seq.length()];
        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                startIndexes.push(i);
                level++;
                max = Math.max(max, level);
            } else { // ')'
                indexes[startIndexes.pop()] = i;
                level--;
            }
        }
        int half = max / 2;
        level = 0;
        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                level++;
                if (level <= half) {
                    if (indexes[i] != null) {
                        answer[i] = 1;
                        answer[indexes[i]] = 1;
                    }
                }
            } else { // ')'
                level--;
            }
        }
        return answer;
    }
}
