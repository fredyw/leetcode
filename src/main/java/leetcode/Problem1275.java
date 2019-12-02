package leetcode;

/**
 * https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/
 */
public class Problem1275 {
    public String tictactoe(int[][] moves) {
        char[][] board = new char[3][3];
        boolean x = true;
        for (int[] move : moves) {
            board[move[0]][move[1]] = x ? 'X' : 'O';
            x = !x;
        }
        if (isWinner(board, 'X')) {
            return "A";
        } else if (isWinner(board, 'O')) {
            return "B";
        } else if (moves.length == 9) {
            return "Draw";
        }
        return "Pending";
    }

    private static boolean isWinner(char[][] board, char c) {
        // horizontal and vertical
        for (int i = 0; i < 3; i++) {
            int rowCount = 0;
            int colCount = 0;
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == c) {
                    colCount++;
                }
                if (board[j][i] == c) {
                    rowCount++;
                }
            }
            if (rowCount == 3 || colCount == 3) {
                return true;
            }
        }
        // diagonal
        int leftDiagonal = 0;
        int rightDiagonal = 0;
        for (int i = 0, j = 2; i < 3; i++, j--) {
            if (board[i][i] == c) {
                leftDiagonal++;
            }
            if (board[i][j] == c) {
                rightDiagonal++;
            }
        }
        return leftDiagonal == 3 || rightDiagonal == 3;
    }
}
