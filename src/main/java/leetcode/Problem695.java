package leetcode;

/**
 * https://leetcode.com/problems/max-area-of-island/
 */
public class Problem695 {
    public int maxAreaOfIsland(int[][] grid) {
        int maxRow = grid.length;
        int maxCol = 0;
        if (grid.length > 0) {
            maxCol = grid[0].length;
        }
        boolean[][] visited = new boolean[maxRow][maxCol];
        int max = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                max = Math.max(max, maxAreaOfIsland(grid, visited, maxRow, maxCol, row, col));
            }
        }
        return max;
    }

    private static int maxAreaOfIsland(int[][] grid, boolean[][] visited, int maxRow, int maxCol,
                                       int row, int col) {
        if (row < 0 || row >= maxRow || col < 0 || col >= maxCol) {
            return 0;
        }
        if (visited[row][col]) {
            return 0;
        }
        visited[row][col] = true;
        if (grid[row][col] == 0) {
            return 0;
        }
        int max = grid[row][col];
        // up
        int a = maxAreaOfIsland(grid, visited, maxRow, maxCol, row - 1, col);
        // right
        int b = maxAreaOfIsland(grid, visited, maxRow, maxCol, row, col + 1);
        // down
        int c = maxAreaOfIsland(grid, visited, maxRow, maxCol, row + 1, col);
        // left
        int d = maxAreaOfIsland(grid, visited, maxRow, maxCol, row, col - 1);
        max += a + b + c + d;
        return max;
    }
}
