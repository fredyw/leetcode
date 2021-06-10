package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/
 */
public class Problem1886 {
    public boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i < 4; i++) {
            rotate(mat);
            if (isEqual(mat, target)) {
                return true;
            }
        }
        return false;
    }

    private static void rotate(int[][] mat) {
        int n = mat.length;
        int[][] tmp = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                tmp[row][col] = mat[row][col];
            }
        }
        int c = n - 1;
        for (int row = 0; row < n; row++) {
            int r = 0;
            for (int col = 0; col < n; col++) {
                mat[r++][c] = tmp[row][col];
            }
            c--;
        }
    }

    private static boolean isEqual(int[][] mat1, int[][] mat2) {
        for (int i = 0; i < mat1.length; i++) {
            if (!Arrays.equals(mat1[i], mat2[i])) {
                return false;
            }
        }
        return true;
    }
}
