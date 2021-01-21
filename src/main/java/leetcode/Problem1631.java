package leetcode;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/path-with-minimum-effort/
 */
public class Problem1631 {
    public int minimumEffortPath(int[][] heights) {
        int maxRow = heights.length;
        int maxCol = maxRow > 0 ? heights[0].length : 0;
        int[][] diffs = new int[maxRow][maxCol];
        PriorityQueue<Vertex> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.diff));
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                diffs[row][col] = Integer.MAX_VALUE;
            }
        }
        // Start from the source.
        diffs[0][0] = 0;
        queue.add(new Vertex(0, 0, diffs[0][0]));
        while (!queue.isEmpty()) {
            Vertex vertex = queue.remove();
            for (int[] neighbor : new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}}) {
                int nextRow = vertex.row + neighbor[0];
                int nextCol = vertex.col + neighbor[1];
                if (nextRow < 0 || nextRow == maxRow || nextCol < 0 || nextCol == maxCol) {
                    continue;
                }
                // Get the maximum absolute difference.
                int newDiff = Math.max(
                    diffs[vertex.row][vertex.col],
                    Math.abs(heights[vertex.row][vertex.col] - heights[nextRow][nextCol]));
                if (diffs[nextRow][nextCol] == Integer.MAX_VALUE || newDiff < diffs[nextRow][nextCol]) {
                    diffs[nextRow][nextCol] = newDiff;
                    Vertex v = new Vertex(nextRow, nextCol, diffs[nextRow][nextCol]);
                    queue.add(v);
                }
            }
        }
        return diffs[maxRow - 1][maxCol - 1];
    }

    private static class Vertex {
        private final int row;
        private final int col;
        private final int diff;

        public Vertex(int row, int col, int diff) {
            this.row = row;
            this.col = col;
            this.diff = diff;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex vertex = (Vertex) o;
            return row == vertex.row && col == vertex.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
}
