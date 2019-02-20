package leetcode;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * https://leetcode.com/problems/random-flip-matrix/
 */
public class Problem519 {
    private static class Solution {
        private final Random random = new Random();
        private Set<String> set = new HashSet<>();
        private final int nRows;
        private final int nCols;

        public Solution(int n_rows, int n_cols) {
            nRows = n_rows;
            nCols = n_cols;
        }

        public int[] flip() {
            int r = random.nextInt(nRows);
            int c = random.nextInt(nCols);
            String key = key(r, c);
            while (set.contains(key)) {
                r = random.nextInt(nRows);
                c = random.nextInt(nCols);
                key = key(r, c);
            }
            set.add(key);
            return new int[]{r, c};
        }

        private String key(int row, int col) {
            return row + "|" + col;
        }

        public void reset() {
            set = new HashSet<>();
        }
    }
}
