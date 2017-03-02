package leetcode;

/**
 * https://leetcode.com/problems/minesweeper/
 */
public class Problem529 {
    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0];
        int col = click[1];
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
            return board;
        }
        int maxRow = board.length;
        int maxCol = 0;
        if (board.length > 0) {
            maxCol = board[0].length;
        }
        boolean[][] visited = new boolean[maxRow][maxCol];
        updateBoard(board, maxRow, maxCol, row, col, visited);
        return board;
    }

    private static void updateBoard(char[][] board, int maxRow, int maxCol, int row, int col,
                                    boolean[][] visited) {
        if (row < 0 || row >= maxRow || col < 0 || col >= maxCol) {
            return;
        }
        if (visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        int count = 0;
        // top
        if (row - 1 >= 0) {
            if (board[row - 1][col] == 'M') {
                count++;
            }
        }
        // top right
        if (row - 1 >= 0 && col + 1 < maxCol) {
            if (board[row - 1][col + 1] == 'M') {
                count++;
            }
        }
        // right
        if (col + 1 < maxCol) {
            if (board[row][col + 1] == 'M') {
                count++;
            }
        }
        // bottom right
        if (row + 1 < maxRow && col + 1 < maxCol) {
            if (board[row + 1][col + 1] == 'M') {
                count++;
            }
        }
        // bottom
        if (row + 1 < maxRow) {
            if (board[row + 1][col] == 'M') {
                count++;
            }
        }
        // bottom left
        if (row + 1 < maxRow && col - 1 >= 0) {
            if (board[row + 1][col - 1] == 'M') {
                count++;
            }
        }
        // left
        if (col - 1 >= 0) {
            if (board[row][col - 1] == 'M') {
                count++;
            }
        }
        // top left
        if (row - 1 >= 0 && col - 1 >= 0) {
            if (board[row - 1][col - 1] == 'M') {
                count++;
            }
        }

        if (count == 0) {
            board[row][col] = 'B';
            // top
            updateBoard(board, maxRow, maxCol, row - 1, col, visited);
            // top right
            updateBoard(board, maxRow, maxCol, row - 1, col + 1, visited);
            // right
            updateBoard(board, maxRow, maxCol, row, col + 1, visited);
            // bottom right
            updateBoard(board, maxRow, maxCol, row + 1, col + 1, visited);
            // bottom
            updateBoard(board, maxRow, maxCol, row + 1, col, visited);
            // bottom left
            updateBoard(board, maxRow, maxCol, row + 1, col - 1, visited);
            // left
            updateBoard(board, maxRow, maxCol, row, col - 1, visited);
            // top left
            updateBoard(board, maxRow, maxCol, row - 1, col - 1, visited);
        } else {
            board[row][col] = (char) (count + 48); // ascii code
        }
    }
}
