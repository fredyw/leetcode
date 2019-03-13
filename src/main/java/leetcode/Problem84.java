package leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 */
public class Problem84 {
    public int largestRectangleArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        Stack<IndexValue> leftStack = new Stack<>();
        int[] leftCounts = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            while (!leftStack.isEmpty() && height[i] <= leftStack.peek().value) {
                leftStack.pop();
            }
            if (!leftStack.isEmpty()) {
                leftCounts[i] = i - leftStack.peek().index;
            } else {
                leftCounts[i] = i + 1;
            }
            leftStack.push(new IndexValue(i, height[i]));
        }

        Stack<IndexValue> rightStack = new Stack<>();
        int[] rightCounts = new int[height.length];
        for (int i = height.length - 1, j = 0; i >= 0; i--, j++) {
            while (!rightStack.isEmpty() && height[i] <= rightStack.peek().value) {
                rightStack.pop();
            }
            if (!rightStack.isEmpty()) {
                rightCounts[i] = rightStack.peek().index - i;
            } else {
                rightCounts[i] = j + 1;
            }
            rightStack.push(new IndexValue(i, height[i]));
        }
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            answer = Math.max(answer, height[i] * (rightCounts[i] + leftCounts[i] - 1));
        }
        return answer;
    }

    private static class IndexValue {
        private final int index;
        private final int value;

        public IndexValue(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
