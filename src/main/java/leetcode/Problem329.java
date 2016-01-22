package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 */
public class Problem329 {
    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        Map<String, Integer> memo = new HashMap<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int val = longestIncreasingPath(matrix, matrix.length, matrix[row].length,
                    row, col, Integer.MIN_VALUE, memo);
                max = Math.max(max, val);
            }
        }
        return max;
    }

    public int longestIncreasingPath(int[][] matrix, int maxRow, int maxCol,
                                     int row, int col, int prevValue, Map<String, Integer> memo) {
        if (0 > row || row >= maxRow || 0 > col || col >= maxCol
            || prevValue >= matrix[row][col]) {
            return 0;
        }
        String key = row + "|" + col;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int value = matrix[row][col];
        // top
        int a = longestIncreasingPath(matrix, maxRow, maxCol, row - 1, col, value, memo) + 1;
        // down
        int b = longestIncreasingPath(matrix, maxRow, maxCol, row + 1, col, value, memo) + 1;
        // left
        int c = longestIncreasingPath(matrix, maxRow, maxCol, row, col - 1, value, memo) + 1;
        // right
        int d = longestIncreasingPath(matrix, maxRow, maxCol, row, col + 1, value, memo) + 1;

        int max = 0;
        max = Math.max(max, a);
        max = Math.max(max, b);
        max = Math.max(max, c);
        max = Math.max(max, d);
        memo.put(key, max);
        return max;
    }
}
