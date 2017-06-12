package leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 */
public class Problem84 {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        int maxArea = 0;
        while (idx < height.length) {
            if (stack.isEmpty() || height[stack.peek()] <= height[idx]) {
                stack.push(idx);
                idx++;
            } else {
                int topIdx = stack.pop();
                int peekIdx = (stack.isEmpty()) ? -1 : stack.peek();
                int width = idx - peekIdx - 1;
                int area = height[topIdx] * width;
                if (maxArea < area) {
                    maxArea = area;
                }
            }
        }
        while (!stack.isEmpty()) {
            int topIdx = stack.pop();
            int peekIdx = (stack.isEmpty()) ? -1 : stack.peek();
            int width = idx - peekIdx - 1;
            int area = height[topIdx] * width;
            if (maxArea < area) {
                maxArea = area;
            }
        }
        return maxArea;
    }
}
