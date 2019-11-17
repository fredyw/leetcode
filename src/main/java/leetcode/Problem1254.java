package leetcode;

/**
 * https://leetcode.com/problems/number-of-closed-islands/
 */
public class Problem1254 {
    public int closedIsland(int[][] grid) {
        int maxRow = grid.length;
        int maxCol = grid.length > 0 ? grid[0].length : 0;
        boolean[][] visited = new boolean[maxRow][maxCol];
        for (int col = 0; col < maxCol; col++) {
            if (!visited[0][col] && grid[0][col] == 0) {
                dfs(grid, visited, maxRow, maxCol, 0, col);
            }
            if (!visited[maxRow - 1][col] && grid[maxRow - 1][col] == 0) {
                dfs(grid, visited, maxRow, maxCol, maxRow - 1, col);
            }
        }
        for (int row = 0; row < maxRow; row++) {
            if (!visited[row][0] && grid[row][0] == 0) {
                dfs(grid, visited, maxRow, maxCol, row, 0);
            }
            if (!visited[row][maxCol - 1] && grid[row][maxCol - 1] == 0) {
                dfs(grid, visited, maxRow, maxCol, row, maxCol - 1);
            }
        }
        int answer = 0;
        for (int row = 1; row < maxRow - 1; row++) {
            for (int col = 1; col < maxCol - 1; col++) {
                if (visited[row][col] || grid[row][col] != 0) {
                    continue;
                }
                dfs(grid, visited, maxRow, maxCol, row, col);
                answer++;
            }
        }
        return answer;
    }

    private static void dfs(int[][] grid, boolean[][] visited,
                            int maxRow, int maxCol,
                            int row, int col) {
        if (row < 0 || row == maxRow || col < 0 || col == maxCol) {
            return;
        }
        if (grid[row][col] != 0 || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        dfs(grid, visited, maxRow, maxCol, row - 1, col); // up
        dfs(grid, visited, maxRow, maxCol, row, col + 1); // right
        dfs(grid, visited, maxRow, maxCol, row + 1, col); // down
        dfs(grid, visited, maxRow, maxCol, row, col - 1); // left
    }
}
