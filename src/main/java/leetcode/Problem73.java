package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 */
public class Problem73 {
    public void setZeroes(int[][] matrix) {
        List<Zero> zeroes = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroes.add(new Zero(i, j));
                }
            }
        }
        for (Zero zero : zeroes) {
            setRowZeroes(matrix, zero.row);
            setColZeroes(matrix, zero.col);
        }
    }

    private static class Zero {
        private final int row;
        private final int col;

        public Zero(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private void setRowZeroes(int[][] matrix, int row) {
        for (int i = 0; i < matrix[row].length; i++) {
            matrix[row][i] = 0;
        }
    }

    private void setColZeroes(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }
}
