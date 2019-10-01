package leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/longest-well-performing-interval/
 */
public class Problem1124 {
    public int longestWPI(int[] hours) {
        int[] sums = new int[hours.length + 1];
        for (int i = 1; i <= hours.length; i++) {
            sums[i] = sums[i - 1] + (hours[i - 1] <= 8 ? -1 : 1);
        }
        System.out.println(Arrays.toString(sums));
        // Monotone decreasing stack.
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= hours.length; i++) {
            if (stack.isEmpty() || sums[stack.peek()] > sums[i]) {
                stack.push(i);
            }
        }
        System.out.println(stack);
        int answer = 0;
        for (int i = hours.length; i >= 0; i--) {
            while (!stack.empty() && sums[stack.peek()] < sums[i]) {
                answer = Math.max(answer, i - stack.peek());
                stack.pop();
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem1124 prob = new Problem1124();
//        System.out.println(prob.longestWPI(new int[]{9,9,6,0,6,6,9})); // 3
        System.out.println(prob.longestWPI(new int[]{8,6,9,9,10,9,0,6,6,9})); // 9
    }
}
