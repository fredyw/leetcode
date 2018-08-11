package leetcode;

/**
 * https://leetcode.com/problems/projection-area-of-3d-shapes/
 */
public class Problem887 {
    public int projectionArea(int[][] grid) {
        int top = 0;
        int front = 0;
        int side = 0;
        for (int i = 0; i < grid.length; i++) {
            int maxRow = 0;
            int maxCol = 0;
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > 0) {
                    top++;
                }
                maxRow = Math.max(maxRow, grid[i][j]);
                maxCol = Math.max(maxCol, grid[j][i]);
            }
            front += maxRow;
            side += maxCol;
        }
        return top + front + side;
    }
}
