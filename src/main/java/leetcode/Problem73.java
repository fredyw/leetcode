package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 */
public class Problem73 {
    public void setZeroes(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    setRowZeroes(matrix, i);
                    setColZeroes(matrix, j);
                }
            }
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
    
    public static void main(String[] args) {
        Problem73 prob = new Problem73();
        int[][] matrix = new int[][] {
            new int[]{1, 0, 1, 1},
            new int[]{0, 1, 1, 1},
            new int[]{1, 1, 1, 1}
        };
        prob.setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
