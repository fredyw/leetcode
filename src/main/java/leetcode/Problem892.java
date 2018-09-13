package leetcode;

/**
 * https://leetcode.com/problems/surface-area-of-3d-shapes/
 */
public class Problem892 {
    public int surfaceArea(int[][] grid) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem892 prob = new Problem892();
        System.out.println(prob.surfaceArea(new int[][]{
            {1}
        })); // 6
        System.out.println(prob.surfaceArea(new int[][]{
            {2}
        })); // 10
        System.out.println(prob.surfaceArea(new int[][]{
            {1, 2}
        })); // 6
        System.out.println(prob.surfaceArea(new int[][]{
            {1, 2}, {3, 4}
        })); // 10
        System.out.println(prob.surfaceArea(new int[][]{
            {1, 0}, {0, 2}
        })); // 10
        System.out.println(prob.surfaceArea(new int[][]{
            {1, 1, 1}, {1, 0, 1}, {1, 1, 1}
        })); // 10
        System.out.println(prob.surfaceArea(new int[][]{
            {2, 2, 2}, {2, 1, 2}, {2, 2, 2}
        })); // 10
    }
}
