package leetcode;

/**
 * https://leetcode.com/problems/flipping-an-image/
 */
public class Problem832 {
    public int[][] flipAndInvertImage(int[][] A) {
        int nRow = A.length;
        int nCol = 0;
        if (nRow > 0) {
            nCol = A[0].length;
        }
        int[][] result = new int[nRow][nCol];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0, k = A.length - 1; j < A.length; j++, k--) {
                result[i][k] = (A[i][j] == 0) ? 1 : 0;
            }
        }
        return result;
    }
}
