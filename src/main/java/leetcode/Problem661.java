package leetcode;

/**
 * https://leetcode.com/problems/image-smoother/
 */
public class Problem661 {
    public int[][] imageSmoother(int[][] M) {
        int maxRow = M.length;
        int maxCol = 0;
        if (maxRow > 0) {
            maxCol = M[0].length;
        }
        int[][] result = new int[maxRow][maxCol];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                result[i][j] = calculate(M, maxRow, maxCol, i, j);
            }
        }
        return result;
    }

    private static int calculate(int[][] m, int maxRow, int maxCol, int row, int col) {
        int total = m[row][col];
        int count = 1;
        // top
        if (row - 1 >= 0) {
            total += m[row - 1][col];
            count++;
        }
        // top right
        if (row - 1 >= 0 && col + 1 < maxCol) {
            total += m[row - 1][col + 1];
            count++;
        }
        // right
        if (col + 1 < maxCol) {
            total += m[row][col + 1];
            count++;
        }
        // bottom right
        if (row + 1 < maxRow && col + 1 < maxCol) {
            total += m[row + 1][col + 1];
            count++;
        }
        // bottom
        if (row + 1 < maxRow) {
            total += m[row + 1][col];
            count++;
        }
        // bottom left
        if (row + 1 < maxRow && col - 1 >= 0) {
            total += m[row + 1][col - 1];
            count++;
        }
        // left
        if (col - 1 >= 0) {
            total += m[row][col - 1];
            count++;
        }
        // top left
        if (row - 1 >= 0 && col - 1 >= 0) {
            total += m[row - 1][col - 1];
            count++;
        }
        return total / count;
    }
}
