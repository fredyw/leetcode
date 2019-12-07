package leetcode;

/**
 * https://leetcode.com/problems/maximal-square/
 */
public class Problem221 {
    public int maximalSquare(char[][] matrix) {
        int maxRow = matrix.length;
        int maxCol = maxRow > 0 ? matrix[0].length : 0;
        int answer = 0;
        Integer[][] memo = new Integer[maxRow][maxCol];
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                answer = Math.max(answer, maximalSquare(matrix, maxRow, maxCol, i, j, memo));
            }
        }
        return answer * answer;
    }

    private static int maximalSquare(char[][] matrix, int maxRow, int maxCol, int row, int col,
                                     Integer[][] memo) {
        if (row < 0 || row == maxRow || col < 0 || col == maxCol) {
            return 0;
        }
        if (memo[row][col] != null) {
            return memo[row][col];
        }
        if (matrix[row][col] == '1') {
            int a = maximalSquare(matrix, maxRow, maxCol, row + 1, col, memo);
            int b = maximalSquare(matrix, maxRow, maxCol, row, col + 1, memo);
            int c = maximalSquare(matrix, maxRow, maxCol, row + 1, col + 1, memo);
            int min = Math.min(a, Math.min(b, c)) + 1;
            memo[row][col] = min;
            return min;
        }
        return 0;
    }
}
