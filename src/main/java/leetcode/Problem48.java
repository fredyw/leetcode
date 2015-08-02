package leetcode;

/**
 * https://leetcode.com/problems/rotate-image/
 */
public class Problem48 {
    public void rotate(int[][] matrix) {
    	int n = matrix.length;
        int[][] tmp = new int[n][n];
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		tmp[i][j] = matrix[i][j];
        	}
        }
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		matrix[j][i] = tmp[n-1-i][j];
        	}
        }
    }
}
