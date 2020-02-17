package leetcode;

/**
 * https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
 */
public class Problem1351 {
    public int countNegatives(int[][] grid) {
        int answer = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = grid[i].length - 1; j >= 0; j--) {
                if (grid[i][j] >= 0) {
                    break;
                }
                answer++;
            }
        }
        return answer;
    }
}
