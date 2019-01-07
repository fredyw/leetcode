package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sudoku-solver/
 */
public class Problem37 {
    public void solveSudoku(char[][] board) {
        // TODO
    }

    private static boolean isValid(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] cols = new boolean[9];
            boolean[] rows = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (cols[board[i][j] - '0' - 1]) {
                        return false;
                    }
                    cols[board[i][j] - '0' - 1] = true;
                }

                if (board[j][i] != '.') {
                    if (rows[board[j][i] - '0' - 1]) {
                        return false;
                    }
                    rows[board[j][i] - '0' - 1] = true;
                }
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isValid(board, i, i + 3, j, j + 3)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int startRow, int endRow,
                                   int startCol, int endCol) {
        boolean[] b = new boolean[9];
        for (int i = startRow; i < endRow; i++) {
            for (int j = startCol; j < endCol; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (b[board[i][j] - '0' - 1]) {
                    return false;
                }
                if (board[i][j] != '.') {
                    b[board[i][j] - '0' - 1] = true;
                }
            }
        }
        return true;
    }

    private static void print(char[][] board) {
        for (char[] c : board) {
            System.out.println(Arrays.toString(c));
        }
    }

    public static void main(String[] args) {
        Problem37 prob = new Problem37();
        prob.solveSudoku(new char[][]{
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        });
    }
}
