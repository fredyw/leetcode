package leetcode;

/**
 * https://leetcode.com/problems/unique-paths-iii/
 */
public class Problem980 {
    public int uniquePathsIII(int[][] grid) {
        int maxRow = grid.length;
        int maxCol = maxRow > 0 ? grid[0].length : 0;
        int row = 0;
        int col = 0;
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                if (grid[i][j] == 1) {
                    row = i;
                    col = j;
                    break;
                }
            }
        }
        return uniquePaths(grid, maxRow, maxCol, row, col);
    }

    private static int uniquePaths(int[][] grid, int maxRow, int maxCol, int row, int col) {
        if (row < 0 || row == maxRow || col < 0 || col == maxCol) {
            return 0;
        }
        if (grid[row][col] == -1 || grid[row][col] == 3) {
            return 0;
        }
        if (grid[row][col] == 2) {
            for (int i = 0; i < maxRow; i++) {
                for (int j = 0; j < maxCol; j++) {
                    if (grid[i][j] == 0) {
                        return 0;
                    }
                }
            }
            return 1;
        }
        grid[row][col] = 3;
        int a = uniquePaths(grid, maxRow, maxCol, row - 1, col); // up
        int b = uniquePaths(grid, maxRow, maxCol, row, col + 1); // right
        int c = uniquePaths(grid, maxRow, maxCol, row + 1, col); // down
        int d = uniquePaths(grid, maxRow, maxCol, row, col - 1); // left
        grid[row][col] = 0; // backtrack
        return a + b + c+ d;
    }

    public static void main(String[] args) {
        Problem980 prob = new Problem980();
        System.out.println(prob.uniquePathsIII(new int[][]{
            {1, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 2, -1}
        })); // 2
        System.out.println(prob.uniquePathsIII(new int[][]{
            {1, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 2}
        })); // 4
        System.out.println(prob.uniquePathsIII(new int[][]{
            {0, 1},
            {2, 0}
        })); // 0
    }
}
