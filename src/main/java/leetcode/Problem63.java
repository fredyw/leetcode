package leetcode;

/**
 * https://leetcode.com/problems/unique-paths-ii/
 */
public class Problem63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) {
            return 0;
        }
        return findPaths(obstacleGrid, obstacleGrid.length-1, obstacleGrid[0].length-1,
            0, 0);
    }
    
    private int findPaths(int[][] grid, int destRow, int destCol, int row, int col) {
        if (row == destRow && col == destCol) {
            return 1;
        } 
        if (row > destRow || col > destCol) {
            return 0;
        }
        if (grid[row][col] == 1) {
            return 0;
        }
        int a = findPaths(grid, destRow, destCol, row+1, col);
        int b = findPaths(grid, destRow, destCol, row, col+1);
        return a + b;
    }
    
    public static void main(String[] args) {
        Problem63 prob = new Problem63();
        int[][] grid = new int[][]{
            new int[]{0, 0, 0},
            new int[]{0, 1, 0},
            new int[]{0, 0, 0},
            new int[]{0, 0, 0},
            new int[]{0, 0, 0},
        };
        System.out.println(prob.uniquePathsWithObstacles(grid));
    }
}
