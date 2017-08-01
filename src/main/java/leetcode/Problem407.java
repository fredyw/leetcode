package leetcode;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/trapping-rain-water-ii/
 */
public class Problem407 {
    public int trapRainWater(int[][] heightMap) {
        // https://www.youtube.com/watch?v=cJayBq38VYw
        int maxRow = heightMap.length;
        int maxCol = 0;
        if (heightMap.length > 0) {
            maxCol = heightMap[0].length;
        }
        boolean[][] visited = new boolean[maxRow][maxCol];
        PriorityQueue<RowCol> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.value, b.value));
        // top
        for (int col = 0; col < maxCol; col++) {
            visited[0][col] = true;
            int val = heightMap[0][col];
            queue.add(new RowCol(0, col, val));
        }
        // left
        for (int row = 1; row < maxRow - 1; row++) {
            visited[row][0] = true;
            int val = heightMap[row][0];
            queue.add(new RowCol(row, 0, val));
        }
        // bottom
        for (int col = 0; col < maxCol; col++) {
            visited[maxRow - 1][col] = true;
            int val = heightMap[maxRow - 1][col];
            queue.add(new RowCol(maxRow - 1, col, val));
        }
        // right
        for (int row = 1; row < maxRow - 1; row++) {
            visited[row][maxCol - 1] = true;
            int val = heightMap[row][maxCol - 1];
            queue.add(new RowCol(row, maxCol - 1, val));
        }
        int result = 0;
        int max = 0;
        while (!queue.isEmpty()) {
            RowCol rowCol = queue.remove();
            max = Math.max(max, rowCol.value);
            // top
            int row = rowCol.row - 1;
            int col = rowCol.col;
            result += process(heightMap, queue, visited, row, col, maxRow, maxCol, max);
            // left
            row = rowCol.row;
            col = rowCol.col - 1;
            result += process(heightMap, queue, visited, row, col, maxRow, maxCol, max);
            // bottom
            row = rowCol.row + 1;
            col = rowCol.col;
            result += process(heightMap, queue, visited, row, col, maxRow, maxCol, max);
            // right
            row = rowCol.row;
            col = rowCol.col + 1;
            result += process(heightMap, queue, visited, row, col, maxRow, maxCol, max);
        }
        return result;
    }

    private static int process(int[][] heightMap,
                                PriorityQueue<RowCol> queue,
                                boolean[][] visited,
                                int row,
                                int col,
                                int maxRow,
                                int maxCol,
                                int max) {
        if (row >= 0 && row < maxRow && col >= 0 && col < maxCol && !visited[row][col]) {
            int result = 0;
            int val = heightMap[row][col];
            if (val < max) {
                val = max - val;
                result = val;
            }
            visited[row][col] = true;
            queue.add(new RowCol(row, col, val));
            return result;
        }
        return 0;
    }

    private static class RowCol {
        private final int row;
        private final int col;
        private final int value;

        public RowCol(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }
}
