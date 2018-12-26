package leetcode;

/**
 * https://leetcode.com/problems/regions-cut-by-slashes/
 */
public class Problem959 {
    public int regionsBySlashes(String[] grid) {
        // Create a new grid that is 3 times as big.
        // For example:
        // "/\\",
        // "\\/"
        // becomes:
        // 00/\00
        // 0/00\0
        // /0000\
        // \0000/
        // 0\00/0
        // 00\/00
        // We can then calculate the number of areas with '0' chars.
        char[][] newGrid = new char[grid.length * 3][grid.length * 3];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                if (grid[i].charAt(j) == '\\') {
                    newGrid[3 * i][3 * j] = '\\';
                    newGrid[3 * i + 1][3 * j + 1] = '\\';
                    newGrid[3 * i + 2][3 * j + 2] = '\\';
                } else if (grid[i].charAt(j) == '/') {
                    newGrid[3 * i][3 * j + 2] = '/';
                    newGrid[3 * i + 1][3 * j + 1] = '/';
                    newGrid[3 * i + 2][3 * j] = '/';
                }
            }
        }
        int answer = 0;
        boolean[][] visited = new boolean[grid.length * 3][grid.length * 3];
        for (int i = 0; i < newGrid.length; i++) {
            for (int j = 0; j < newGrid[i].length; j++) {
                if (!visited[i][j] && newGrid[i][j] == 0) {
                    traverse(newGrid, visited, i, j);
                    answer++;
                }
            }
        }
        return answer;
    }

    private static void traverse(char[][] grid, boolean[][] visited, int i, int j) {
        int maxRow = grid.length;
        int maxCol = grid.length > 0 ? grid[0].length : 0;
        if (i < 0 || j < 0 || i >= maxRow || j >= maxCol) {
            return;
        }
        if (visited[i][j] || grid[i][j] != 0) {
            return;
        }
        visited[i][j] = true;
        // top
        traverse(grid, visited, i - 1, j);
        // right
        traverse(grid, visited, i, j + 1);
        // bottom
        traverse(grid, visited, i + 1, j);
        // left
        traverse(grid, visited, i, j - 1);
    }
}
