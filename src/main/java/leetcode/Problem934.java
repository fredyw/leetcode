package leetcode;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/shortest-bridge/
 */
public class Problem934 {
    public int shortestBridge(int[][] A) {
        int maxRow = A.length;
        int maxCol = maxRow > 0 ? A[0].length : 0;
        int[][] island1 = new int[maxRow][maxCol];
        outer:
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                if (A[row][col] == 1) {
                    traverse(A, maxRow, maxCol, row, col, island1);
                    break outer;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int row = 0; row < island1.length; row++) {
            for (int col = 0; col < island1[row].length; col++) {
                if (island1[row][col] == 1) {
                    min = Math.min(min, distance(maxRow, maxCol, row, col, A, island1));
                }
            }
        }
        return min;
    }

    private static class RowColLevel {
        private final int row;
        private final int col;
        private final int level;

        public RowColLevel(int row, int col, int level) {
            this.row = row;
            this.col = col;
            this.level = level;
        }
    }

    private static int distance(int maxRow, int maxCol, int row, int col,
                                int[][] a, int[][] island1) {
        int distance = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[maxRow][maxCol];
        LinkedList<RowColLevel> queue = new LinkedList<>();
        queue.add(new RowColLevel(row, col, 0));
        while (!queue.isEmpty()) {
            RowColLevel current = queue.remove();
            if (a[current.row][current.col] == 1 && island1[current.row][current.col] == 0) {
                distance = current.level;
                break;
            }
            if (visited[current.row][current.col]) {
                continue;
            }
            visited[current.row][current.col] = true;
            // top
            if (current.row - 1 >= 0) {
                if (island1[current.row - 1][current.col] == 0) {
                    queue.add(new RowColLevel(current.row - 1, current.col, current.level + 1));
                }
            }
            // right
            if (current.col + 1 < maxCol) {
                if (island1[current.row][current.col + 1] == 0) {
                    queue.add(new RowColLevel(current.row, current.col + 1, current.level + 1));
                }
            }
            // bottom
            if (current.row + 1 < maxRow) {
                if (island1[current.row + 1][current.col] == 0) {
                    queue.add(new RowColLevel(current.row + 1, current.col, current.level + 1));
                }
            }
            // left
            if (current.col - 1 >= 0) {
                if (island1[current.row][current.col - 1] == 0) {
                    queue.add(new RowColLevel(current.row, current.col - 1, current.level + 1));
                }
            }
        }
        return distance - 1;
    }

    private static void traverse(int[][] a, int maxRow, int maxCol, int row, int col,
                                 int[][] island) {
        if (row < 0 || row >= maxRow || col < 0 || col >= maxCol) {
            return;
        }
        if (island[row][col] == 1 || a[row][col] == 0) {
            return;
        }
        island[row][col] = 1;
        // top
        traverse(a, maxRow, maxCol, row - 1, col, island);
        // right
        traverse(a, maxRow, maxCol, row, col + 1, island);
        // bottom
        traverse(a, maxRow, maxCol, row + 1, col, island);
        // left
        traverse(a, maxRow, maxCol, row, col - 1, island);
    }
}
