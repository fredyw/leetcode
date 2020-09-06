package leetcode;

/**
 * https://leetcode.com/problems/matrix-diagonal-sum/
 */
public class Problem1572 {
    public int diagonalSum(int[][] mat) {
        int answer = 0;
        int maxRow = mat.length;
        int maxCol = maxRow > 0 ? mat[0].length : 0;
        for (int i = 0, j = 0; i < maxRow; i++, j++) {
            answer += mat[i][j];
        }
        for (int i = 0, j = maxCol - 1; i < maxRow; i++, j--) {
            answer += mat[i][j];
        }
        return maxRow % 2 == 0 ? answer : answer - mat[maxRow / 2][maxRow / 2];
    }
}
