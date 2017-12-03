package leetcode;

/**
 * https://leetcode.com/problems/asteroid-collision/
 */
public class Problem735 {
    public int[] asteroidCollision(int[] asteroids) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem735 prob = new Problem735();
        System.out.println(prob.asteroidCollision(new int[]{5, 10, -5})); // [5, 10]
        System.out.println(prob.asteroidCollision(new int[]{8, -8})); // []
        System.out.println(prob.asteroidCollision(new int[]{10, 2, -5})); // [8]
        System.out.println(prob.asteroidCollision(new int[]{-2, -1, 1, 2})); // [-2, -1, 1, 2]
    }
}
