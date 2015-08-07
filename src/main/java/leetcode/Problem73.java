package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 */
public class Problem73 {
    public void setZeroes(int[][] matrix) {
        
    }
    
    public static void main(String[] args) {
        Problem73 prob = new Problem73();
        int[][] matrix = new int[][] {
            new int[]{1, 0, 1, 1},
            new int[]{0, 1, 1, 1},
            new int[]{0, 1, 1, 1}
        };
        prob.setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
