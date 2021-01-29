package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/largest-submatrix-with-rearrangements/
 */
public class Problem1727 {
    public int largestSubmatrix(int[][] matrix) {
        int maxRow = matrix.length;
        int maxCol = maxRow > 0 ? matrix[0].length : 0;
        for (int col = 0; col < maxCol; col++) {
            int count = 0;
            for (int row = 0; row < maxRow; row++) {
                count = matrix[row][col] == 0 ? 0 : count + 1;
                matrix[row][col] = count;
            }
        }
        int answer = 0;
        for (int[] m : matrix) {
            Arrays.sort(m);
            for (int col = 0; col < maxCol; col++) {
                answer = Math.max(answer, m[col] * (maxCol - col));
            }
        }
        return answer;
    }
}
