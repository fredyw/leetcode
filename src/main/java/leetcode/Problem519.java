package leetcode;

import java.util.Random;

/**
 * https://leetcode.com/problems/random-flip-matrix/
 */
public class Problem519 {
    class Solution {
        private final Random random = new Random();
        private int[][] matrix;
        private final int nRows;
        private final int nCols;

        public Solution(int n_rows, int n_cols) {
            nRows = n_rows;
            nCols = n_cols;
            matrix = new int[n_rows][n_cols];
        }

        public int[] flip() {
            int r = random.nextInt(nRows);
            int c = random.nextInt(nCols);
            while (matrix[r][c] == 1) {
                r = random.nextInt(nRows);
                c = random.nextInt(nCols);
            }
            matrix[r][c] = 1;
            return new int[]{r, c};
        }

        public void reset() {
            matrix = new int[nRows][nCols];
        }
    }

    public static void main(String[] args) {
        Problem519 prob = new Problem519();
    }
}
