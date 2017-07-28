package leetcode;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/trapping-rain-water-ii/
 */
public class Problem407 {
    public int trapRainWater(int[][] heightMap) {
        // https://www.youtube.com/watch?v=cJayBq38VYw
        PriorityQueue<RowCol> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.value, b.value));
        // top
        for (int col = 0; col < heightMap[0].length; col++) {
            queue.add(new RowCol(0, col, heightMap[0][col]));
        }
        // left
        for (int row = 1; row < heightMap.length - 1; row++) {
            queue.add(new RowCol(row, 0, heightMap[row][0]));
        }
        // bottom
        for (int col = 0; col < heightMap[heightMap.length - 1].length; col++) {
            queue.add(new RowCol(heightMap.length - 1, col, heightMap[heightMap.length - 1][col]));
        }
        // right
        for (int row = 1; row < heightMap.length - 1; row++) {
            queue.add(new RowCol(row, heightMap[row].length - 1, heightMap[row][heightMap[row].length - 1]));
        }
        // TODO:
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

    public static void main(String[] args) {
        Problem407 prob = new Problem407();
        System.out.println(prob.trapRainWater(new int[][]{
            {1, 4, 3, 1, 3, 2},
            {2, 3, 3, 2, 3, 1},
            {2, 3, 3, 2, 3, 1}
        })); // 4
    }
}
