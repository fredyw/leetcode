package leetcode;

/**
 * https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/
 */
public class Problem1252 {
    public int oddCells(int n, int m, int[][] indices) {
        int[][] matrix = new int[n][m];
        for (int[] index : indices) {
            int row = index[0];
            int col = index[1];
            matrix[row][col] += 2;
            // up
            for (int r = row - 1; r >= 0; r--) {
                matrix[r][col]++;
            }
            // right
            for (int c = col + 1; c < m; c++) {
                matrix[row][c]++;
            }
            // down
            for (int r = row + 1; r < n; r++) {
                matrix[r][col]++;
            }
            // left
            for (int c = col - 1; c >= 0; c--) {
                matrix[row][c]++;
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] % 2 != 0) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
