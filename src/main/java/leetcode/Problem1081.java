package leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 */
public class Problem1081 {
    public String smallestSubsequence(String text) {
        Stack<Integer> stack = new Stack<>();
        int[] last = new int[26];
        boolean[] visited = new boolean[26];
        for (int i = 0; i < text.length(); i++) {
            last[text.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < text.length(); i++) {
            int c = text.charAt(i) - 'a';
            if (visited[c]) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c && i < last[stack.peek()]) {
                visited[stack.pop()] = false;
            }
            stack.push(c);
            visited[c] = true;
        }
        StringBuilder answer = new StringBuilder();
        for (int i : stack) {
            answer.append((char)('a' + i));
        }
        return answer.toString();
    }
}
