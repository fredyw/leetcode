package leetcode;

/**
 * https://leetcode.com/problems/surface-area-of-3d-shapes/
 */
public class Problem892 {
    public int surfaceArea(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                result += 4 * grid[i][j];
                if (j - 1 >= 0) {
                    int diff = Math.abs(grid[i][j - 1] - grid[i][j]);
                    result -= 2 * diff;
                }
                if (i - 1 >= 0) {
                    int diff = Math.abs(grid[i - 1][j] - grid[i][j]);
                    result -= 2 * diff;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem892 prob = new Problem892();
//        System.out.println(prob.surfaceArea(new int[][]{
//            {1}
//        })); // 6
//        System.out.println(prob.surfaceArea(new int[][]{
//            {2}
//        })); // 10
//        System.out.println(prob.surfaceArea(new int[][]{
//            {3}
//        })); // 14
        System.out.println(prob.surfaceArea(new int[][]{
            {1, 2}, {3, 4}
        })); // 34
//        System.out.println(prob.surfaceArea(new int[][]{
//            {1, 1}, {1, 1}
//        })); // 16
//        System.out.println(prob.surfaceArea(new int[][]{
//            {1, 0}, {0, 2}
//        })); // 16
//        System.out.println(prob.surfaceArea(new int[][]{
//            {1, 1, 1}, {1, 0, 1}, {1, 1, 1}
//        })); // 32
//        System.out.println(prob.surfaceArea(new int[][]{
//            {2, 2, 2}, {2, 1, 2}, {2, 2, 2}
//        })); // 46
    }
}
