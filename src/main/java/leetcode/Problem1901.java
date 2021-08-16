package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-a-peak-element-ii/
 */
public class Problem1901 {
    public int[] findPeakGrid(int[][] mat) {
        int maxRow = mat.length;
        int maxCol = mat.length > 0 ? mat[0].length : 0;
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                int value = mat[row][col];
                if (row - 1 >= 0 && value <= mat[row - 1][col]) {
                    continue;
                }
                if (col + 1 < maxCol && value <= mat[row][col + 1]) {
                    continue;
                }
                if (row + 1 < maxRow && value <= mat[row + 1][col]) {
                    continue;
                }
                if (col - 1 >= 0 && value <= mat[row][col - 1]) {
                    continue;
                }
                return new int[]{row, col};
            }
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        Problem1901 prob = new Problem1901();
        System.out.println(Arrays.toString(prob.findPeakGrid(new int[][]{
            {1,4},
            {3,2}
        }))); // [0,1]
        System.out.println(Arrays.toString(prob.findPeakGrid(new int[][]{
            {10,20,15},
            {21,30,14},
            {7,16,32}
        }))); // [1,1]
    }
}
