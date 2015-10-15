package leetcode;

/**
 * https://leetcode.com/problems/game-of-life/
 */
public class Problem289 {
    public void gameOfLife(int[][] board) {
        int[][] original = new int[board.length][];
        for (int row = 0; row < board.length; row++) {
            original[row] = new int[board[row].length];
            for (int col = 0; col < board[row].length; col++) {
                original[row][col] = board[row][col];
            }
        }
        for (int row = 0; row < original.length; row++) {
            for (int col = 0; col < original[row].length; col++) {
                update(board, original, row, col);
            }
        }
    }

    private void update(int[][] board, int[][] original, int row, int col) {
        int maxRow = original.length;
        int maxCol = original[0].length;
        int nw = 0;
        if (row - 1 >= 0 && col - 1 >= 0) {
            nw = original[row - 1][col - 1];
        }
        int n = 0;
        if (row - 1 >= 0) {
            n = original[row - 1][col];
        }
        int ne = 0;
        if (row - 1 >= 0 && col + 1 < maxCol) {
            ne = original[row - 1][col + 1];
        }
        int w = 0;
        if (col - 1 >= 0) {
            w = original[row][col - 1];
        }
        int e = 0;
        if (col + 1 < maxCol) {
            e = original[row][col + 1];
        }
        int sw = 0;
        if (row + 1 < maxRow && col - 1 >= 0) {
            sw = original[row + 1][col - 1];
        }
        int s = 0;
        if (row + 1 < maxRow) {
            s = original[row + 1][col];
        }
        int se = 0;
        if (row + 1 < maxRow && col + 1 < maxCol) {
            se = original[row + 1][col + 1];
        }
        int numNeighbor = nw + n + ne + w + e + sw + s + se;
        if (numNeighbor < 2 || numNeighbor > 3) {
            // kill it
            board[row][col] = 0;
        } else if (numNeighbor == 3) {
            // resurrect it
            board[row][col] = 1;
        }
    }
}
