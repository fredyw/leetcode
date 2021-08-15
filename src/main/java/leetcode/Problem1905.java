package leetcode;

/**
 * https://leetcode.com/problems/count-sub-islands/
 */
public class Problem1905 {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int maxRow = grid1.length;
        int maxCol = grid1.length > 0 ? grid1[0].length : 0;
        boolean[][] visited = new boolean[maxRow][maxCol];
        int islandNumber = 1;
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                markIslands(grid1, maxRow, maxCol, visited, i, j, islandNumber++);
            }
        }
        int answer = 0;
        visited = new boolean[maxRow][maxCol];
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                if (grid1[i][j] == 0 || grid2[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                if (isSubIsland(grid1, grid2, maxRow, maxCol, visited, i, j, grid1[i][j])) {
                    answer++;
                }
            }
        }
        return answer;
    }

    private static void markIslands(int[][] grid, int maxRow, int maxCol, boolean[][] visited,
                                    int row, int col, int islandNumber) {
        if (row < 0 || row == maxRow || col < 0 || col == maxCol) {
            return;
        }
        if (visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        if (grid[row][col] == 0) {
            return;
        }
        grid[row][col] = islandNumber;
        markIslands(grid, maxRow, maxCol, visited, row - 1, col, islandNumber);
        markIslands(grid, maxRow, maxCol, visited, row, col + 1, islandNumber);
        markIslands(grid, maxRow, maxCol, visited, row + 1, col, islandNumber);
        markIslands(grid, maxRow, maxCol, visited, row, col - 1, islandNumber);
    }

    private static boolean isSubIsland(int[][] grid1, int[][] grid2, int maxRow, int maxCol,
                                       boolean[][] visited, int row, int col, int islandNumber) {
        if (row < 0 || row == maxRow || col < 0 || col == maxCol) {
            return true;
        }
        if (visited[row][col]) {
            return true;
        }
        visited[row][col] = true;
        if (grid2[row][col] == 0) {
            return true;
        }
        boolean up = isSubIsland(grid1, grid2, maxRow, maxCol, visited, row - 1, col, islandNumber);
        boolean right = isSubIsland(grid1, grid2, maxRow, maxCol, visited, row, col + 1, islandNumber);
        boolean down = isSubIsland(grid1, grid2, maxRow, maxCol, visited, row + 1, col, islandNumber);
        boolean left = isSubIsland(grid1, grid2, maxRow, maxCol, visited, row, col - 1, islandNumber);
        return up && right && down && left && grid1[row][col] == islandNumber;
    }
}
