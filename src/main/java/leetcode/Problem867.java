package leetcode;

/**
 * https://leetcode.com/problems/transpose-matrix/
 */
public class Problem867 {
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
}
