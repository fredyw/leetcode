package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/rotate-image/
 */
public class Problem48 {
    public void rotate(int[][] matrix) {
        
    }
    
    public static void main(String[] args) {
		Problem48 prob = new Problem48();
		int n = 3;
		int[][] matrix = new int[n][n];
		int val = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = val++;
			}
		}
		prob.rotate(matrix);
		for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}
}
