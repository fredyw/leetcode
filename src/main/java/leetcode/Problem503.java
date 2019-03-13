package leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/next-greater-element-ii/
 */
public class Problem503 {
    public int[] nextGreaterElements(int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxIdx = i;
            }
        }
        int[] answer = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = maxIdx, j = 0; j < nums.length; i--, j++) {
            if (i < 0) {
                i = nums.length - 1;
            }
            while (!stack.isEmpty() && nums[i] >= stack.peek()) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                answer[i] = stack.peek();
            } else {
                answer[i] = -1;
            }
            stack.push(nums[i]);
        }
        return answer;
    }
}
