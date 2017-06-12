package leetcode;

/**
 * https://leetcode.com/problems/valid-sudoku/
 */
public class Problem36 {
    public boolean isValidSudoku(char[][] board) {
        boolean all = isValidSudokuFullGrid(board);
        if (!all) {
            return false;
        }
        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board.length; j += 3) {
                if (!isValidSudokuSubGrid(board, i, i + 3, j, j + 3)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidSudokuFullGrid(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            boolean[] rows = new boolean[9];
            boolean[] cols = new boolean[9];
            for (int col = 0; col < board[row].length; col++) {
                char c = board[row][col];
                if (c != '.') {
                    if (rows[board[row][col] - '0' - 1]) {
                        return false;
                    }
                    rows[board[row][col] - '0' - 1] = true;
                }

                c = board[col][row];
                if (c != '.') {
                    if (cols[board[col][row] - '0' - 1]) {
                        return false;
                    }
                    cols[board[col][row] - '0' - 1] = true;
                }
            }
        }
        return true;
    }

    private boolean isValidSudokuSubGrid(char[][] board, int startRow, int endRow,
                                         int startCol, int endCol) {
        boolean[] nums = new boolean[9];
        for (int i = startRow; i < endRow; i++) {
            for (int j = startCol; j < endCol; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                if (nums[board[i][j] - '0' - 1]) {
                    return false;
                }
                nums[board[i][j] - '0' - 1] = true;
            }
        }
        return true;
    }
}
