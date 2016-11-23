package leetcode;

/**
 * https://leetcode.com/problems/island-perimeter/
 */
public class Problem463 {
    public int islandPerimeter(int[][] grid) {
        int maxRow = grid.length;
        int maxCol = grid[0].length;
        boolean[][] visited = new boolean[maxRow][maxCol];
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                if (grid[i][j] == 1) {
                    return visit(grid, visited, maxRow, maxCol, i, j);
                }
            }
        }
        return 0;
    }

    private static int visit(int[][] grid, boolean[][] visited, int maxRow, int maxCol,
                             int row, int col) {
        if (row < 0 || row >= maxRow || col < 0 || col >= maxCol) {
            return 1;
        }
        if (visited[row][col]) {
            return 0;
        }
        if (grid[row][col] == 0) {
            return 1;
        }
        visited[row][col] = true;
        int a = 0;
        // top
        int b = visit(grid, visited, maxRow, maxCol, row - 1, col);
        // right
        int c = visit(grid, visited, maxRow, maxCol, row, col + 1);
        // bottom
        int d = visit(grid, visited, maxRow, maxCol, row + 1, col);
        // left
        int e = visit(grid, visited, maxRow, maxCol, row, col - 1);
        return a + b + c + d + e;
    }
}
