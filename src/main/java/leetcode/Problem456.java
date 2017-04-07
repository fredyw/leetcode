package leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/132-pattern/
 */
public class Problem456 {
    public boolean find132pattern(int[] nums) {
        int[] ones = new int[nums.length];
        boolean[] candidates = new boolean[nums.length];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                min = nums[i];
            } else if (min < nums[i]) {
                ones[i] = min;
                candidates[i] = true;
            } else {
                min = nums[i];
            }
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (candidates[i]) {
                int three = nums[i];
                while (!stack.isEmpty() && three > stack.peek()) {
                    int two = stack.pop();
                    if (ones[i] < two && three > two) {
                        return true;
                    }
                }
            }
            stack.add(nums[i]);
        }
        return false;
    }
}
