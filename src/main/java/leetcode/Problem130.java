package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
                    Result result = solve(board, visited, board.length, board[row].length,
                        row, col);
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

    private Result solve(char[][] board, boolean[][] visited, int maxRow, int maxCol,
                         int row, int col) {
        Result result = new Result();
        Queue<RowCol> rowCols = new LinkedList<>();
        rowCols.add(new RowCol(row, col));
        while (!rowCols.isEmpty()) {
            RowCol rc = rowCols.remove();
            if (rc.row < 0 || rc.row >= maxRow ||
                rc.col < 0 || rc.col >= maxCol) {
                continue;
            }
            if (visited[rc.row][rc.col]) {
                continue;
            }
            visited[rc.row][rc.col] = true;
            if (board[rc.row][rc.col] != 'O') {
                continue;
            } else {
                if (rc.row == 0 || rc.row == maxRow - 1 || rc.col == 0 || rc.col == maxCol - 1) {
                    result.surrounded = false;
                }
                result.rowCols.add(new RowCol(rc.row, rc.col));
            }
            // left
            rowCols.add(new RowCol(rc.row, rc.col - 1));
            // up
            rowCols.add(new RowCol(rc.row - 1, rc.col));
            // right
            rowCols.add(new RowCol(rc.row, rc.col + 1));
            // down
            rowCols.add(new RowCol(rc.row + 1, rc.col));
        }
        return result;
    }
}
