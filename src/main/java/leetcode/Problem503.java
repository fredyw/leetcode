package leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/next-greater-element-ii/
 */
public class Problem503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] answer = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
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

    public static void main(String[] args) {
        Problem503 prob = new Problem503();
        System.out.println(Arrays.toString(prob.nextGreaterElements(new int[]{1, 2, 1}))); // [2,-1,2]
        System.out.println(Arrays.toString(prob.nextGreaterElements(new int[]{1, 2, 1, 1}))); // [2,-1,2,2]
    }
}
