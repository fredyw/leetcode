package leetcode;

/**
 * https://leetcode.com/problems/largest-1-bordered-square/
 */
public class Problem1139 {
    public int largest1BorderedSquare(int[][] grid) {
        int answer = 0;
        int maxRow = grid.length;
        int maxCol = grid.length > 0 ? grid[0].length : 0;
        int[][] rowSums = new int[maxRow][maxCol];
        for (int col = 0; col < maxCol; col++) {
            for (int row = 0; row < maxRow; row++) {
                if (grid[row][col] == 1) {
                    if (row - 1 >= 0) {
                        rowSums[row][col] += rowSums[row - 1][col] + 1;
                    } else {
                        rowSums[row][col] = 1;
                    }
                }
            }
        }
        int[][] colSums = new int[maxRow][maxCol];
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                if (grid[row][col] == 1) {
                    if (col - 1 >= 0) {
                        colSums[row][col] += colSums[row][col - 1] + 1;
                    } else {
                        colSums[row][col] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                // Make sure this is a square.
                for (int k = 1; k <= Math.min(maxRow, maxCol) && i + k <= maxRow && j + k <= maxCol; k++) {
                    if (isValid(rowSums, colSums, i, j, k)) {
                        answer = Math.max(answer, k * k);
                    }
                }
            }
        }
        return answer;
    }

    private static boolean isValid(int[][] rowSums, int[][] colSums, int row, int col, int k) {
        if (rowSums[row][col] == 0) {
            return false;
        }
        if (rowSums[row + k - 1][col] < k || rowSums[row + k - 1][col + k - 1] < k) {
            return false;
        }
        if (colSums[row][col + k - 1] < k || colSums[row + k - 1][col + k -1] < k) {
            return false;
        }
        return true;
    }
}
