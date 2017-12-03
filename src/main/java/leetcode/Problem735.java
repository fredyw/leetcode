package leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/asteroid-collision/
 */
public class Problem735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty()) {
                stack.push(asteroids[i]);
            } else {
                int a = stack.pop();
                if (a > 0 && asteroids[i] < 0) {
                    int sum = a + asteroids[i];
                    if (sum < 0) {
                        stack.push(asteroids[i]);
                    } else if (sum > 0) {
                        stack.push(a);
                    }
                }
            }
        }
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        Problem735 prob = new Problem735();
        System.out.println(Arrays.toString(prob.asteroidCollision(new int[]{5, 10, -5}))); // [5, 10]
        System.out.println(Arrays.toString(prob.asteroidCollision(new int[]{8, -8}))); // []
        System.out.println(Arrays.toString(prob.asteroidCollision(new int[]{10, 2, -5}))); // [10]
        System.out.println(Arrays.toString(prob.asteroidCollision(new int[]{-2, -1, 1, 2}))); // [-2, -1, 1, 2]
    }
}
