package leetcode;

/**
 * https://leetcode.com/problems/unique-paths-ii/
 */
public class Problem63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // TODO: implement this
        return 0;
    }
    
    public static void main(String[] args) {
        Problem63 prob = new Problem63();
        int[][] grid = new int[][]{
            new int[]{0, 0, 0},
            new int[]{0, 1, 0},
            new int[]{0, 0, 0}
        };
        System.out.println(prob.uniquePathsWithObstacles(grid));
    }
}
