package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 */
public class Problem417 {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> answer = new ArrayList<>();
        int maxRow = matrix.length;
        int maxCol = matrix.length > 0 ? matrix[0].length : 0;
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                boolean[][] visited = new boolean[maxRow][maxCol];
                Ocean ocean = pacificAtlantic(matrix, maxRow, maxCol, i, j,
                    Integer.MAX_VALUE, visited);
                if (ocean.pacific && ocean.atlantic) {
                    answer.add(new int[]{i, j});
                }
            }
        }
        return answer;
    }

    private static class Ocean {
        private boolean pacific;
        private boolean atlantic;
    }

    private static Ocean pacificAtlantic(int[][] matrix, int maxRow, int maxCol,
                                         int row, int col, int previous, boolean[][] visited) {
        if (row < 0 || col < 0) {
            Ocean ocean = new Ocean();
            ocean.pacific = true;
            return ocean;
        }
        if (row == maxRow || col == maxCol) {
            Ocean ocean = new Ocean();
            ocean.atlantic = true;
            return ocean;
        }
        if (visited[row][col]) {
            return null;
        }
        int val = matrix[row][col];
        if (val > previous) {
            return null;
        }
        visited[row][col] = true;
        Ocean ocean = new Ocean();
        Ocean a = pacificAtlantic(matrix, maxRow, maxCol, row - 1, col, val, visited);
        if (a != null) {
            ocean.atlantic |= a.atlantic;
            ocean.pacific |= a.pacific;
        }
        Ocean b = pacificAtlantic(matrix, maxRow, maxCol, row, col + 1, val, visited);
        if (b != null) {
            ocean.atlantic |= b.atlantic;
            ocean.pacific |= b.pacific;
        }
        Ocean c = pacificAtlantic(matrix, maxRow, maxCol, row + 1, col, val, visited);
        if (c != null) {
            ocean.atlantic |= c.atlantic;
            ocean.pacific |= c.pacific;
        }
        Ocean d = pacificAtlantic(matrix, maxRow, maxCol, row, col - 1, val, visited);
        if (d != null) {
            ocean.atlantic |= d.atlantic;
            ocean.pacific |= d.pacific;
        }
        return ocean;
    }
}
