package leetcode;

/**
 * https://leetcode.com/problems/valid-boomerang/
 */
public class Problem1037 {
    public boolean isBoomerang(int[][] points) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem1037 prob = new Problem1037();
        System.out.println(prob.isBoomerang(new int[][]{
            {1, 1}, {2, 3}, {3, 2}
        })); // true
        System.out.println(prob.isBoomerang(new int[][]{
            {1, 1}, {2, 2}, {3, 3}
        })); // false
        System.out.println(prob.isBoomerang(new int[][]{
            {0, 1}, {0, 2}, {0, 3}
        })); // false
        System.out.println(prob.isBoomerang(new int[][]{
            {0, 1}, {0, 2}, {2, 3}
        })); // true
        System.out.println(prob.isBoomerang(new int[][]{
            {0, 1}, {0, 1}, {0, 1}
        })); // false
        System.out.println(prob.isBoomerang(new int[][]{
            {0, 1}, {0, 1}, {0, 1}
        })); // false
        System.out.println(prob.isBoomerang(new int[][]{
            {1, 1}, {2, 3}, {3, 5}
        })); // false
        System.out.println(prob.isBoomerang(new int[][]{
            {1, 1}, {2, 3}, {3, 6}
        })); // true
    }
}
