package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
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
        for (int i = 0; i < maxRow; i++) {
            result.add(new ArrayList<>());
            for (int j = 0; j < maxCol; j++) {
                int val = matrix.get(i).get(j);
                if (val == 0) {
                    result.get(i).add(0);
                } else {
                    int distance = shortest(matrix, new boolean[maxRow][maxCol], maxRow, maxCol, i, j);
                    result.get(i).add(distance);
                }
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

    private static int shortest(List<List<Integer>> matrix, boolean[][] visited,
                                int maxRow, int maxCol, int row, int col) {
        Queue<RowCol> rowCols = new LinkedList<>();
        rowCols.add(new RowCol(row, col, 0));
        while (!rowCols.isEmpty()) {
            RowCol rowCol = rowCols.remove();
            int val = matrix.get(rowCol.row).get(rowCol.col);
            if (val == 0) {
                return rowCol.distance;
            }
            if (visited[rowCol.row][rowCol.col]) {
                continue;
            }
            visited[rowCol.row][rowCol.col] = true;
            // up
            if (rowCol.row - 1 >= 0) {
                rowCols.add(new RowCol(rowCol.row - 1, rowCol.col, rowCol.distance + 1));
            }
            // right
            if (rowCol.col + 1 < maxCol) {
                rowCols.add(new RowCol(rowCol.row, rowCol.col + 1, rowCol.distance + 1));
            }
            // down
            if (rowCol.row + 1 < maxRow) {
                rowCols.add(new RowCol(rowCol.row + 1, rowCol.col, rowCol.distance + 1));
            }
            // left
            if (rowCol.col - 1 >= 0) {
                rowCols.add(new RowCol(rowCol.row, rowCol.col - 1, rowCol.distance + 1));
            }
        }
        return 0;
    }

    private static void print(List<List<Integer>> matrix) {
        for (int i = 0; i < matrix.size(); i++) {
            System.out.println(matrix.get(i));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Problem542 prob = new Problem542();

        // 0 0 0
        // 0 1 0
        // 0 0 0
        print(prob.updateMatrix(Arrays.asList(
            Arrays.asList(0, 0, 0),
            Arrays.asList(0, 1, 0),
            Arrays.asList(0, 0, 0)
        )));

        // 0 0 0
        // 0 1 0
        // 1 2 1
        print(prob.updateMatrix(Arrays.asList(
            Arrays.asList(0, 0, 0),
            Arrays.asList(0, 1, 0),
            Arrays.asList(1, 1, 1)
        )));

        // 0 0 0
        // 1 1 1
        // 2 2 2
        print(prob.updateMatrix(Arrays.asList(
            Arrays.asList(0, 0, 0),
            Arrays.asList(1, 1, 1),
            Arrays.asList(1, 1, 1)
        )));

        // 0 1 0
        // 1 2 1
        // 2 3 2
        print(prob.updateMatrix(Arrays.asList(
            Arrays.asList(0, 1, 0),
            Arrays.asList(1, 1, 1),
            Arrays.asList(1, 1, 1)
        )));

        // 0 1 0
        // 0 1 0
        // 0 1 0
        // 0 1 0
        // 0 1 0
        print(prob.updateMatrix(Arrays.asList(
            Arrays.asList(0, 1, 0),
            Arrays.asList(0, 1, 0),
            Arrays.asList(0, 1, 0),
            Arrays.asList(0, 1, 0),
            Arrays.asList(0, 1, 0)
        )));
        
        // 0 0 1 0 1 2 1 0 1 2
        // 1 1 2 1 0 1 2 1 2 3
        print(prob.updateMatrix(Arrays.asList(
            Arrays.asList(0, 0, 1, 0, 1, 1, 1, 0, 1, 1),
            Arrays.asList(1, 1, 1, 1, 0, 1, 1, 1, 1, 1)
        )));
    }
}
