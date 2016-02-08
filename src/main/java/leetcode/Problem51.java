package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/n-queens/
 */
public class Problem51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '.';
            }
        }
        nQueens(board, 0, result);
        return result;
    }

    private void nQueens(char[][] board, int row, List<List<String>> result) {
        if (row == board.length) {
            List<String> solution = new ArrayList<>();
            for (char[] chars : board) {
                solution.add(new String(chars));
            }
            result.add(solution);
            return;
        }
        for (int col = 0; col < board[row].length; col++) {
            if (!isPossible(board, row, col)) {
                continue;
            }
            board[row][col] = 'Q';
            nQueens(board, row + 1, result);
            // reset everything
            board[row][col] = '.';
        }
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
}
