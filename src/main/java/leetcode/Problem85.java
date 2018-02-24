package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximal-rectangle/
 */
public class Problem85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int nCols = matrix[0].length;
        int[] left = new int[nCols];
        int[] right = new int[nCols];
        int[] height = new int[nCols];
        Arrays.fill(right, nCols);
        int result = 0;
        for (char[] row : matrix) {
            int curLeft = 0;
            for (int col = 0; col < nCols; col++) {
                if (row[col] == '1') {
                    left[col] = Math.max(left[col], curLeft);
                    height[col]++;
                } else {
                    left[col] = 0;
                    curLeft = col + 1;
                    height[col] = 0;
                }
            }
            int curRight = nCols;
            for (int col = nCols - 1; col >= 0; col--) {
                if (row[col] == '1') {
                    right[col] = Math.min(right[col], curRight);
                } else {
                    right[col] = nCols;
                    curRight = col;
                }
            }
            for (int col = 0; col < nCols; col++) {
                result = Math.max(result, (right[col] - left[col]) * height[col]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem85 prob = new Problem85();
        System.out.println(prob.maximalRectangle(new char [][]{
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'},
        })); // 6
    }
}
