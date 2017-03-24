package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/01-matrix/
 */
public class Problem542 {
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        int maxRow = matrix.size();
        int maxCol = 0;
        if (matrix.size() > 0) {
            maxCol = matrix.get(0).size();
        }
        List<List<Integer>> result = new ArrayList<>();
        boolean[][] visited = new boolean[maxRow][maxCol];
        Queue<RowCol> rowCols = new LinkedList<>();
        for (int i = 0; i < maxRow; i++) {
            result.add(new ArrayList<>());
            for (int j = 0; j < maxCol; j++) {
                if (matrix.get(i).get(j) == 0) {
                    rowCols.add(new RowCol(i, j, 0));
                    visited[i][j] = true;
                }
                result.get(i).add(0);
            }
        }
        while (!rowCols.isEmpty()) {
            RowCol rowCol = rowCols.remove();
            result.get(rowCol.row).set(rowCol.col, rowCol.distance);
            // up
            if (rowCol.row - 1 >= 0 && !visited[rowCol.row - 1][rowCol.col]) {
                rowCols.add(new RowCol(rowCol.row - 1, rowCol.col, rowCol.distance + 1));
                visited[rowCol.row - 1][rowCol.col] = true;
            }
            // right
            if (rowCol.col + 1 < maxCol && !visited[rowCol.row][rowCol.col + 1]) {
                rowCols.add(new RowCol(rowCol.row, rowCol.col + 1, rowCol.distance + 1));
                visited[rowCol.row][rowCol.col + 1] = true;
            }
            // down
            if (rowCol.row + 1 < maxRow && !visited[rowCol.row + 1][rowCol.col]) {
                rowCols.add(new RowCol(rowCol.row + 1, rowCol.col, rowCol.distance + 1));
                visited[rowCol.row + 1][rowCol.col] = true;
            }
            // left
            if (rowCol.col - 1 >= 0 && !visited[rowCol.row][rowCol.col - 1]) {
                rowCols.add(new RowCol(rowCol.row, rowCol.col - 1, rowCol.distance + 1));
                visited[rowCol.row][rowCol.col - 1] = true;
            }
        }
        return result;
    }

    private static class RowCol {
        private final int row;
        private final int col;
        private final int distance;

        public RowCol(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }
}
