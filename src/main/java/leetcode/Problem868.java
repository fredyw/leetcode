package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/transpose-matrix/
 */
public class Problem868 {
    public int[][] transpose(int[][] A) {
        int nRow = A.length;
        int nCol = 0;
        if (A.length > 0) {
            nCol = A[0].length;
        }
        int[][] result = new int[nCol][nRow];
        for (int row = 0; row < nRow; row++) {
            for (int col = 0; col < nCol; col++) {
                result[col][row] = A[row][col];
            }
        }
        return result;
    }

    private static void print(int[][] matrix) {
        for (int[] array : matrix) {
            System.out.println(Arrays.toString(array));
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Problem868 prob = new Problem868();
        // [1, 4, 7],
        // [2, 5, 8],
        // [3, 6, 9]
        print(prob.transpose(new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        }));
        // [1, 4],
        // [2, 5],
        // [3, 6]
        print(prob.transpose(new int[][]{
            {1, 2, 3},
            {4, 5, 6}
        }));
    }
}
