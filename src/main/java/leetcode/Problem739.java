package leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/daily-temperatures/
 */
public class Problem739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()) {
                stack.add(i);
            } else {
                int j = stack.peek();
                while (temperatures[j] < temperatures[i]) {
                    result[j] = i - j;
                    stack.pop();
                    if (stack.isEmpty()) {
                        break;
                    }
                    j = stack.peek();
                }
                stack.add(i);
            }
        }
        return result;
    }
}
