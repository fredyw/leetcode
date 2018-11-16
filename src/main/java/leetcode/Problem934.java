package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/shortest-bridge/
 */
public class Problem934 {
    public int shortestBridge(int[][] A) {
        int maxRow = A.length;
        int maxCol = maxRow > 0 ? A[0].length : 0;
        int[][] island1 = new int[maxRow][maxCol];
        int[][] island2 = new int[maxRow][maxCol];
        boolean second = false;
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                if (A[row][col] == 1) {
                    if (island1[row][col] == 1 || island2[row][col] == 1) {
                        continue;
                    }
                    if (!second) {
                        traverse(A, maxRow, maxCol, row, col, island1);
                        second = true;
                    } else {
                        traverse(A, maxRow, maxCol, row, col, island2);
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int row = 0; row < island1.length; row++) {
            for (int col = 0; col < island1[row].length; col++) {
                if (island1[row][col] == 1) {
                    min = Math.min(min, distance(maxRow, maxCol, row, col, A, island1, island2));
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
                                int[][] a, int[][] island1, int[][] island2) {
        int distance = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[maxRow][maxCol];
        LinkedList<RowColLevel> queue = new LinkedList<>();
        queue.add(new RowColLevel(row, col, 0));
        while (!queue.isEmpty()) {
            RowColLevel current = queue.remove();
            if (island2[current.row][current.col] == 1) {
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

    private static void print(int[][] a) {
        for (int[] i : a) {
            System.out.println(Arrays.toString(i));
        }
    }

    public static void main(String[] args) {
        Problem934 prob = new Problem934();
        System.out.println(prob.shortestBridge(new int[][]{
            {0, 1},
            {1, 0}
        })); // 1
        System.out.println(prob.shortestBridge(new int[][]{
            {0, 1, 0},
            {0, 0, 0},
            {0, 0, 1}
        })); // 2
        System.out.println(prob.shortestBridge(new int[][]{
            {0, 1, 1},
            {0, 0, 0},
            {1, 1, 0}
        })); // 1
        System.out.println(prob.shortestBridge(new int[][]{
            {1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1}
        })); // 1
        System.out.println(prob.shortestBridge(new int[][]{
            {1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 1, 0, 1},
            {1, 1, 0, 1, 1}
        })); // 1
    }
}
