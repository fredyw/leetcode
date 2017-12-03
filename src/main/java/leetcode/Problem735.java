package leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/asteroid-collision/
 */
public class Problem735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            stack.push(asteroids[i]);
            if (stack.size() <= 1) {
                continue;
            }
            while (true) {
                if (stack.size() <= 1) {
                    break;
                }
                int right = stack.pop();
                int left = stack.pop();
                if (left > 0 && right < 0) {
                    int sum = left + right;
                    if (sum < 0) {
                        stack.push(right);
                    } else if (sum > 0) {
                        stack.push(left);
                    }
                } else {
                    stack.push(left);
                    stack.push(right);
                    break;
                }
            }
        }
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
