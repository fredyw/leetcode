package leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/array-nesting/
 */
public class Problem565 {
    public int arrayNesting(int[] nums) {
        int max = 0;
        boolean[] processed = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (processed[i]) {
                continue;
            }
            Stack<Integer> stack = new Stack<>();
            int idx = i;
            stack.push(nums[idx]);
            int count = 0;
            while (!processed[idx]) {
                count++;
                processed[idx] = true;
                idx = stack.pop();
                stack.push(nums[idx]);
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
