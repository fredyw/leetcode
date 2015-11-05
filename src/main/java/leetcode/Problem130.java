package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/surrounded-regions/
 */
public class Problem130 {
    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (visited[row][col]) {
                    continue;
                }
                if (board[row][col] == 'O') {
//                    System.out.println("found O at " + row + ", " + col);
                    Result result = new Result();
                    solve(board, visited, board.length, board[row].length, row, col, result);
                    if (result.surrounded) {
                        for (RowCol rc : result.rowCols) {
                            board[rc.row][rc.col] = 'X';
                        }
                    }
                } else {
                    visited[row][col] = true;
                }
            }
        }
    }

    private static class RowCol {
        private final int row;
        private final int col;

        public RowCol(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static class Result {
        private boolean surrounded = true;
        private final List<RowCol> rowCols = new ArrayList<>();
    }

    private void solve(char[][] board, boolean[][] visited, int maxRow, int maxCol,
                       int row, int col, Result result) {
        if (row < 0 || row >= maxRow || col < 0 || col >= maxCol) {
            return;
        }
        if (visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        if (board[row][col] != 'O') {
            return;
        } else {
            if (row == 0 || row == maxRow - 1 || col == 0 || col == maxCol - 1) {
                result.surrounded = false;
            }
//            System.out.println("  - adding " + row + ", " + col);
            result.rowCols.add(new RowCol(row, col));
        }
        // left
        solve(board, visited, maxRow, maxCol, row, col - 1, result);
        // up
        solve(board, visited, maxRow, maxCol, row - 1, col, result);
        // right
        solve(board, visited, maxRow, maxCol, row, col + 1, result);
        // down
        solve(board, visited, maxRow, maxCol, row + 1, col, result);
    }

    public static void main(String[] args) {
        Problem130 prob = new Problem130();
        char[][] board = new char[][]{
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'},
        };
        prob.solve(board);
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
