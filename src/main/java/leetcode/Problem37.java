package leetcode;

/**
 * https://leetcode.com/problems/sudoku-solver/
 */
public class Problem37 {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private static boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                for (char k = '1'; k <= '9'; k++) {
                    board[i][j] = k;
                    if (isValid(board) && solve(board)) {
                        return true;
                    }
                    board[i][j] = '.';
                }
                return false;
            }
        }
        return true;
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
}
