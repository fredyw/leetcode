package leetcode;

/**
 * https://leetcode.com/problems/n-queens-ii/
 */
public class Problem52 {
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '.';
            }
        }
        return nQueens(board, 0);
    }

    private int nQueens(char[][] board, int row) {
        if (row == board.length) {
            return 1;
        }
        int result = 0;
        for (int col = 0; col < board[row].length; col++) {
            if (!isPossible(board, row, col)) {
                continue;
            }
            board[row][col] = 'Q';
            result += nQueens(board, row + 1);
            // reset everything
            board[row][col] = '.';
        }
        return result;
    }

    private boolean isPossible(char[][] board, int row, int col) {
        // up row
        for (int i = row; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // right diagonal
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem52 prob = new Problem52();
        System.out.println(prob.totalNQueens(8));
    }
}
