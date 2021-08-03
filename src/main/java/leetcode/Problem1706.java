package leetcode;

/**
 * https://leetcode.com/problems/where-will-the-ball-fall/
 */
public class Problem1706 {
    public int[] findBall(int[][] grid) {
        int maxRow = grid.length;
        int maxCol = grid.length > 0 ? grid[0].length : 0;
        int[] answer = new int[maxCol];
        for (int ball = 0; ball < maxCol; ball++) {
            int col = ball;
            for (int row = 0; row < maxRow; row++) {
                if (grid[row][col] == 1) {
                    if (col + 1 < maxCol && grid[row][col + 1] == -1) {
                        answer[ball] = -1; // stuck
                        break;
                    }
                    col++;
                } else { // grid[row][col] == -1
                    if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                        answer[ball] = -1; // stuck
                        break;
                    }
                    col--;
                }
                if (col < 0 || col == maxCol) {
                    answer[ball] = -1; // stuck
                    break;
                }
                if (row == maxRow - 1) {
                    answer[ball] = col;
                }
            }
        }
        return answer;
    }
}
