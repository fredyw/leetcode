package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/
 */
public class Problem1391 {
    public boolean hasValidPath(int[][] grid) {
        int maxRow = grid.length;
        int maxCol = grid[0].length;
        Queue<RowCol> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maxRow][maxCol];
        queue.add(new RowCol(0, 0));
        while (!queue.isEmpty()) {
            RowCol current = queue.remove();
            int row = current.row;
            int col = current.col;
            if (visited[row][col]) {
                continue;
            }
            if (row == maxRow - 1 && col == maxCol - 1) {
                return true;
            }
            visited[row][col] = true;
            if (grid[row][col] == 1) {
                if (col - 1 >= 0 &&
                    (grid[row][col - 1] == 1 || grid[row][col - 1] == 4 || grid[row][col - 1] == 6)) {
                    queue.add(new RowCol(row, col - 1));
                }
                if (col + 1 < maxCol &&
                    (grid[row][col + 1] == 1 || grid[row][col + 1] == 3 || grid[row][col + 1] == 5)) {
                    queue.add(new RowCol(row, col + 1));
                }
            } else if (grid[row][col] == 2) {
                if (row - 1 >= 0 &&
                    (grid[row - 1][col] == 2 || grid[row - 1][col] == 3 || grid[row - 1][col] == 4)) {
                    queue.add(new RowCol(row - 1, col));
                }
                if (row + 1 < maxRow &&
                    (grid[row + 1][col] == 2 || grid[row + 1][col] == 5 || grid[row + 1][col] == 6)) {
                    queue.add(new RowCol(row + 1, col));
                }
            } else if (grid[row][col] == 3) {
                if (col - 1 >= 0 &&
                    (grid[row][col - 1] == 1 || grid[row][col - 1] == 4 || grid[row][col - 1] == 6)) {
                    queue.add(new RowCol(row, col - 1));
                }
                if (row + 1 < maxRow &&
                    (grid[row + 1][col] == 2 || grid[row + 1][col] == 5 || grid[row + 1][col] == 6)) {
                    queue.add(new RowCol(row + 1, col));
                }
            } else if (grid[row][col] == 4) {
                if (col + 1 < maxCol &&
                    (grid[row][col + 1] == 1 || grid[row][col + 1] == 3 || grid[row][col + 1] == 5)) {
                    queue.add(new RowCol(row, col + 1));
                }
                if (row + 1 < maxRow &&
                    (grid[row + 1][col] == 2 || grid[row + 1][col] == 5 || grid[row + 1][col] == 6)) {
                    queue.add(new RowCol(row + 1, col));
                }
            } else if (grid[row][col] == 5) {
                if (row - 1 >= 0 &&
                    (grid[row - 1][col] == 2 || grid[row - 1][col] == 3 || grid[row - 1][col] == 4)) {
                    queue.add(new RowCol(row - 1, col));
                }
                if (col - 1 >= 0 &&
                    (grid[row][col - 1] == 1 || grid[row][col - 1] == 4 || grid[row][col - 1] == 6)) {
                    queue.add(new RowCol(row, col - 1));
                }
            } else { // grid[row][col] == 6
                if (row - 1 >= 0 &&
                    (grid[row - 1][col] == 2 || grid[row - 1][col] == 3 || grid[row - 1][col] == 4)) {
                    queue.add(new RowCol(row - 1, col));
                }
                if (col + 1 < maxCol &&
                    (grid[row][col + 1] == 1 || grid[row][col + 1] == 3 || grid[row][col + 1] == 5)) {
                    queue.add(new RowCol(row, col + 1));
                }
            }
        }
        return false;
    }

    private static class RowCol {
        private final int row;
        private final int col;

        public RowCol(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
