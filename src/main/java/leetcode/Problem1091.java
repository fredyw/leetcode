package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/
 */
public class Problem1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int maxRow = grid.length;
        int maxCol = maxRow > 0 ? grid[0].length : 0;
        boolean[][] visited = new boolean[maxRow][maxCol];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        int answer = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.remove();
                int row = current[0];
                int col = current[1];
                if (grid[row][col] == 1) {
                    continue;
                }
                if (row == maxRow - 1 && col == maxCol - 1) {
                    return answer + 1;
                }
                for (int[] neighbor : new int[][]{
                    {-1, 0}, {0, 1}, {1, 0}, {0, -1},
                    {-1, 1}, {1, 1}, {1, -1}, {-1, -1}
                }) {
                    int r = row + neighbor[0];
                    int c = col + neighbor[1];
                    if (r < 0 || r == maxRow || c < 0 || c == maxCol) {
                        continue;
                    }
                    if (visited[r][c] || grid[r][c] == 1) {
                        continue;
                    }
                    queue.add(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
            answer++;
        }
        return -1;
    }
}
