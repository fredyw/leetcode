package leetcode;

/**
 * https://leetcode.com/problems/number-of-islands/
 */
public class Problem200 {
    public int numIslands(char[][] grid) {
        int maxRow = grid.length;
        int maxCol = maxRow > 0 ? grid[0].length : 0;
        boolean[][] visited = new boolean[maxRow][maxCol];
        int answer = 0;
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                if (grid[i][j] == '1') {
                    if (!visited[i][j]) {
                        answer++;
                        numIslands(grid, maxRow, maxCol, i, j, visited);
                    }
                }
            }
        }
        return answer;
    }

    private static void numIslands(char[][] grid, int maxRow, int maxCol,
                                   int row, int col, boolean[][] visited) {
        if (row < 0 || row == maxRow || col < 0 || col == maxCol) {
            return;
        }
        if (visited[row][col] || grid[row][col] == '0') {
            return;
        }
        visited[row][col] = true;
        numIslands(grid, maxRow, maxCol, row - 1, col, visited); // up
        numIslands(grid, maxRow, maxCol, row, col + 1, visited); // right
        numIslands(grid, maxRow, maxCol, row + 1, col, visited); // down
        numIslands(grid, maxRow, maxCol, row, col - 1, visited); // left
    }
}
