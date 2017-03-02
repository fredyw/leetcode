package leetcode;

import java.util.Arrays;

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
        // TODO
        return board;
    }

    private static void updateBoard(char[][] board, int maxRow, int maxCol, int row, int col) {
        if (row < 0 || row >= maxRow || col < 0 || col >= maxCol) {
            return;
        }
        // top
        updateBoard(board, maxRow, maxCol, row - 1, col);
        // top right
        updateBoard(board, maxRow, maxCol, row - 1, col + 1);
        // right
        updateBoard(board, maxRow, maxCol, row, col + 1);
        // bottom right
        updateBoard(board, maxRow, maxCol, row + 1, col + 1);
        // bottom
        updateBoard(board, maxRow, maxCol, row + 1, col);
        // bottom left
        updateBoard(board, maxRow, maxCol, row + 1, col - 1);
        // left
        updateBoard(board, maxRow, maxCol, row, col - 1);
        // top left
        updateBoard(board, maxRow, maxCol, row - 1, col - 1);
    }

    private static void print(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Problem529 prob = new Problem529();

        // [['B', '1', 'E', '1', 'B'],
        //  ['B', '1', 'X', '1', 'B'],
        //  ['B', '1', '1', '1', 'B'],
        //  ['B', 'B', 'B', 'B', 'B']]
        print(prob.updateBoard(new char[][]{
            {'E', 'E', 'E', 'E', 'E'},
            {'E', 'E', 'M', 'E', 'E'},
            {'E', 'E', 'E', 'E', 'E'},
            {'E', 'E', 'E', 'E', 'E'}}, new int[]{3, 0}));

        // [['B', '1', 'E', '1', 'B'],
        //  ['B', '1', 'X', '1', 'B'],
        //  ['B', '1', '1', '1', 'B'],
        //  ['B', 'B', 'B', 'B', 'B']]
        print(prob.updateBoard(new char[][]{
            {'B', '1', 'E', '1', 'B'},
            {'B', '1', 'M', '1', 'B'},
            {'B', '1', '1', '1', 'B'},
            {'B', 'B', 'B', 'B', 'B'}}, new int[]{1, 2}));

        // [['E', 'M', 'E', '1', 'B'],
        //  ['1', '2', 'M', '1', 'B'],
        //  ['B', '1', '1', '1', 'B'],
        //  ['B', 'B', 'B', 'B', 'B']]
        print(prob.updateBoard(new char[][]{
            {'E', 'M', 'E', 'E', 'E'},
            {'E', 'E', 'M', 'E', 'E'},
            {'E', 'E', 'E', 'E', 'E'},
            {'E', 'E', 'E', 'E', 'E'}}, new int[]{3, 0}));
    }
}
