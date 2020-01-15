package leetcode;

/**
 * https://leetcode.com/problems/matrix-block-sum/
 */
public class Problem1314 {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int maxRow = mat.length;
        int maxCol = maxRow > 0 ? mat[0].length : 0;
        int[][] sums = new int[maxRow][maxCol];
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                if (col == 0) {
                    sums[row][col] = mat[row][col];
                } else {
                    sums[row][col] = sums[row][col - 1] + mat[row][col];
                }
            }
        }
        int[][] answer = new int[maxRow][maxCol];
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                int sum = 0;
                for (int r = Math.max(0, row - K); r <= Math.min(maxRow - 1, row + K); r++) {
                    sum += (col + K >= maxCol ? sums[r][maxCol - 1] : sums[r][col + K]) -
                        (col - K - 1 < 0 ? 0 : sums[r][col - K - 1]);
                }
                answer[row][col] = sum;
            }
        }
        return answer;
    }
}
