package leetcode;

/**
 * https://leetcode.com/problems/coloring-a-border/
 */
public class Problem1034 {
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int maxRow = grid.length;
        int maxCol = maxRow > 0 ? grid[0].length : 0;
        int oldColor = grid[r0][c0];
        boolean[][] visited = new boolean[maxRow][maxCol];
        boolean[][] changed = new boolean[maxRow][maxCol];
        colorBorder(grid, maxRow, maxCol, r0, c0, oldColor, color, visited, changed);
        return grid;
    }

    private static void colorBorder(int[][] grid, int maxRow, int maxCol,
                                    int row, int col, int oldColor, int newColor,
                                    boolean[][] visited, boolean[][] changed) {
        if (row < 0 || row == maxRow || col < 0 || col == maxCol) {
            return;
        }
        if (grid[row][col] != oldColor) {
            return;
        }
        if (visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        if (row == 0 || row == maxRow - 1 || col == 0 || col == maxCol - 1) {
            grid[row][col] = newColor;
            changed[row][col] = true;
        }
        if ((row - 1 >= 0 && grid[row - 1][col] != oldColor && !changed[row - 1][col]) ||
            (col + 1 < maxCol && grid[row][col + 1] != oldColor && !changed[row][col + 1]) ||
            (row + 1 < maxRow && grid[row + 1][col] != oldColor && !changed[row + 1][col]) ||
            (col - 1 >= 0 && grid[row][col - 1] != oldColor && !changed[row][col - 1])) {
            grid[row][col] = newColor;
            changed[row][col] = true;
        }
        colorBorder(grid, maxRow, maxCol, row - 1, col, oldColor, newColor, visited, changed); // up
        colorBorder(grid, maxRow, maxCol, row, col + 1, oldColor, newColor, visited, changed); // right
        colorBorder(grid, maxRow, maxCol, row + 1, col, oldColor, newColor, visited, changed); // down
        colorBorder(grid, maxRow, maxCol, row, col - 1, oldColor, newColor, visited, changed); // left
    }
}
