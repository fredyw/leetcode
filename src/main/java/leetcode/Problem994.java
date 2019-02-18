package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/rotting-oranges/
 */
public class Problem994 {
    public int orangesRotting(int[][] grid) {
        int maxRow = grid.length;
        int maxCol = maxRow > 0 ? grid[0].length : 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean fresh = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh = true;
                }
            }
        }
        if (queue.isEmpty() && !fresh) {
            return 0;
        }
        int answer = -1;
        while (!queue.isEmpty()) {
            Queue<int[]> tmp = new LinkedList<>();
            answer++;
            while (!queue.isEmpty()) {
                int[] current = queue.remove();
                int row = current[0];
                int col = current[1];
                if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                    grid[row - 1][col] = 2;
                    tmp.add(new int[]{row - 1, col});
                }
                if (col + 1 < maxCol && grid[row][col + 1] == 1) {
                    grid[row][col + 1] = 2;
                    tmp.add(new int[]{row, col + 1});
                }
                if (row + 1 < maxRow && grid[row + 1][col] == 1) {
                    grid[row + 1][col] = 2;
                    tmp.add(new int[]{row + 1, col});
                }
                if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                    grid[row][col - 1] = 2;
                    tmp.add(new int[]{row, col - 1});
                }
            }
            queue.addAll(tmp);
        }
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return answer;
    }
}
