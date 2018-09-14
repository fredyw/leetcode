package leetcode;

/**
 * https://leetcode.com/problems/surface-area-of-3d-shapes/
 */
public class Problem892 {
    public int surfaceArea(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                result += 6 * grid[i][j];
                if (grid[i][j] > 1) {
                    result -= 2 * (grid[i][j] - 1);
                }
                if (j - 1 >= 0) {
                    int min = Math.min(grid[i][j - 1], grid[i][j]);
                    result -= 2 * min;
                }
                if (i - 1 >= 0) {
                    int min = Math.min(grid[i - 1][j], grid[i][j]);
                    result -= 2 * min;
                }
            }
        }
        return result;
    }
}
