package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/matrix-block-sum/
 */
public class Problem1314 {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int maxRow = mat.length;
        int maxCol = maxRow > 0 ? mat[0].length : 0;
        int[][] rowSums = new int[maxRow][maxCol];
        int[][] colSums = new int[maxRow][maxCol];
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                if (col == 0) {
                    colSums[row][col] = mat[row][col];
                } else {
                    colSums[row][col] = colSums[row][col - 1] + mat[row][col];
                }
                if (row == 0) {
                    rowSums[row][col] = mat[row][col];
                } else {
                    rowSums[row][col] = rowSums[row - 1][col] + mat[row][col];
                }
            }
        }
        int[][] answer = new int[maxRow][maxCol];
        // TODO
        return answer;
    }

    private static void print(int[][] mat) {
        for (int[] m : mat) {
            System.out.println(Arrays.toString(m));
        }
    }

    public static void main(String[] args) {
        Problem1314 prob = new Problem1314();
        print(prob.matrixBlockSum(new int[][]{
            {1,2,3},
            {4,5,6},
            {7,8,9}
        }, 1)); // [[12,21,16],[27,45,33],[24,39,28]]
//        print(prob.matrixBlockSum(new int[][]{
//            {1,2,3},
//            {4,5,6},
//            {7,8,9}
//        }, 2)); // [[45,45,45],[45,45,45],[45,45,45]]
    }
}
