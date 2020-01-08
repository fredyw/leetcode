package leetcode;

/**
 * https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/
 */
public class Problem1292 {
    public int maxSideLength(int[][] mat, int threshold) {
        int maxRow = mat.length;
        int maxCol = maxRow > 0 ? mat[0].length : 0;
        int[][] rowSums = new int[maxRow][maxCol];
        int[][] colSums = new int[maxRow][maxCol];
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                if (col - 1 < 0) {
                    rowSums[row][col] = mat[row][col];
                } else {
                    rowSums[row][col] = rowSums[row][col - 1] + mat[row][col];
                }
                if (row - 1 < 0) {
                    colSums[row][col] = mat[row][col];
                } else {
                    colSums[row][col] += colSums[row - 1][col] + mat[row][col];
                }
            }
        }
        int answer = 0;
        for (int row = maxRow - 1; row >= 0; row--) {
            for (int col = maxCol - 1; col >= 0; col--) {
                int sum = 0;
                for (int side = 0; side < Math.min(maxRow, maxCol) && row - side >= 0 && col - side >= 0; side++) {
                    if (side == 0) {
                        sum = mat[row][col];
                    } else {
                        int row1 = row - side;
                        int col1 = col - side;
                        int row2 = row;
                        int col2 = col;
                        int r = rowSums[row1][col2] - (col1 - 1 < 0 ? 0 : rowSums[row1][col1 - 1]);
                        int c = colSums[row2][col1] - (row1 - 1 < 0 ? 0 : colSums[row1 - 1][col1]);
                        sum = r + c - mat[row1][col1] + sum;
                    }
                    if (sum > threshold) {
                        break;
                    }
                    answer = Math.max(answer, side + 1);
                }
            }
        }
        return answer;
    }
}
