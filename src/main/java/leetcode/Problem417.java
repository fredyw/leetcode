package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 */
public class Problem417 {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }
        int maxRow = matrix.length;
        int maxCol = matrix[0].length;
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                boolean found = pacificAtlantic(matrix, maxRow, maxCol, row, col);
                if (found) {
                    result.add(new int[]{row, col});
                }
            }
        }
        return result;
    }

    private static boolean pacificAtlantic(int[][] matrix, int maxRow, int maxCol,
                                           int row, int col) {
        boolean pacific = false;
        boolean atlantic = false;
        Set<RowCol> visited = new HashSet<>();
        LinkedList<RowCol> queue = new LinkedList<>();
        RowCol start = new RowCol(row, col);
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            RowCol rc = queue.remove();
            if (rc.row < 0 || rc.row >= maxRow || rc.col < 0 || rc.col >= maxCol) {
                if (rc.row < 0 || rc.col < 0) {
                    pacific = true;
                }
                if (rc.row >= maxRow || rc.col >= maxCol) {
                    atlantic = true;
                }
                if (pacific && atlantic) {
                    return true;
                }
            } else {
                int val = matrix[rc.row][rc.col];
                RowCol up = new RowCol(rc.row - 1, rc.col);
                if (!visited.contains(up)) {
                    if (up.row < 0 || matrix[up.row][up.col] <= val) {
                        queue.add(up);
                        visited.add(up);
                    }
                }
                RowCol right = new RowCol(rc.row, rc.col + 1);
                if (!visited.contains(right)) {
                    if (right.col >= maxCol || matrix[right.row][right.col] <= val) {
                        queue.add(right);
                        visited.add(right);
                    }
                }
                RowCol down = new RowCol(rc.row + 1, rc.col);
                if (!visited.contains(down)) {
                    if (down.row >= maxRow || matrix[down.row][down.col] <= val) {
                        queue.add(down);
                        visited.add(down);
                    }
                }
                RowCol left = new RowCol(rc.row, rc.col - 1);
                if (!visited.contains(left)) {
                    if (left.col < 0 || matrix[left.row][left.col] <= val) {
                        queue.add(left);
                        visited.add(left);
                    }
                }
            }
        }
        return pacific && atlantic;
    }

    private static class RowCol {
        private final int row;
        private final int col;

        public RowCol(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            RowCol rowCol = (RowCol) o;
            return row == rowCol.row &&
                col == rowCol.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }

        @Override
        public String toString() {
            return "(" + row + ", " + col + ")";
        }
    }

    public static void main(String[] args) {
        Problem417 prob = new Problem417();
        // [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]]
        prob.pacificAtlantic(new int[][]{
            {1, 2, 2, 3, 5},
            {3, 2, 3, 4, 4},
            {2, 4, 5, 3, 1},
            {6, 7, 1, 4, 5},
            {5, 1, 1, 2, 4}
        }).forEach(e -> {
            System.out.print("[" + e[0] + ", " + e[1] + "] ");
        });
        System.out.println();
    }
}
