package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/game-of-life/
 */
public class Problem289 {
    public void gameOfLife(int[][] board) {
        int[][] original = new int[board.length][];
        for (int row = 0; row < board.length; row++) {
            original[row] = new int[board[row].length];
            for (int col = 0; col < board[row].length; col++) {
                original[row][col] = board[row][col];
                board[row][col] = 0;
            }
        }
        for (int row = 0; row < original.length; row++) {
            for (int col = 0; col < original[row].length; col++) {
                update(board, original, row, col);
            }
        }
    }

    private void update(int[][] board, int[][] original, int row, int col) {
        int maxRow = original.length;
        int maxCol = original[0].length;
        System.out.println("maxrow=" + maxRow + ", maxcol=" + maxCol);
        int nw = 0;
        if (row - 1 >= 0 && col - 1 >= 0) {
            nw = original[row - 1][col - 1];
            System.out.print("nw=" + nw + " ");
        }
        int n = 0;
        if (row - 1 >= 0) {
            n = original[row - 1][col];
            System.out.print("n=" + n + " ");
        }
        int ne = 0;
        if (row - 1 >= 0 && col + 1 < maxCol) {
            ne = original[row - 1][col + 1];
            System.out.print("ne=" + ne + " ");
        }
        System.out.println();
        int w = 0;
        if (col - 1 >= 0) {
            w = original[row][col - 1];
            System.out.print("w=" + w + " ");
        }
        int c = original[row][col];
        System.out.print("c=" + c + " ");
        int e = 0;
        if (col + 1 < maxCol) {
            e = original[row][col + 1];
            System.out.print("e=" + e + " ");
        }
        System.out.println();
        int sw = 0;
        if (row + 1 < maxRow && col - 1 >= 0) {
            sw = original[row + 1][col - 1];
            System.out.print("sw=" + sw + " ");
        }
        int s = 0;
        if (row + 1 < maxRow) {
            s = original[row + 1][col];
            System.out.print("s=" + s + " ");
        }
        int se = 0;
        if (row + 1 < maxRow && col + 1 < maxCol) {
            se = original[row + 1][col + 1];
            System.out.print("se=" + s + " ");
        }
        System.out.println();
        int numNeighbor = nw + n + ne + w + c + e + sw + s + se;
        System.out.println("neighbors=" + numNeighbor);
        if (numNeighbor < 2 || numNeighbor > 3) {
            // kill all cells
            update(board, row, col, 0);
        } else if (numNeighbor == 2 || numNeighbor == 3) {
            if (numNeighbor == 3) {
                // resurrect all the dead cells!
                update(board, row, col, 1);
            }
        }
        print(board);
        System.out.println("===========================================================");
    }

    private void update(int[][] board, int row, int col, int val) {
        int maxRow = board.length;
        int maxCol = board[0].length;
        // northwest
        if (row - 1 >= 0 && col - 1 >= 0) {
            board[row - 1][col - 1] = board[row - 1][col - 1] | val;
        }
        // north
        if (row - 1 >= 0) {
            board[row - 1][col] = board[row - 1][col] | val;
        }
        // northeast
        if (row - 1 >= 0 && col + 1 < maxCol) {
            board[row - 1][col + 1] = board[row - 1][col + 1] | val;
        }
        // west
        if (col - 1 >= 0) {
            board[row][col - 1] = board[row][col - 1] | val;
        }
        // central
        board[row][col] = board[row][col] | val;
        // east
        if (col + 1 < maxCol) {
            board[row][col + 1] = board[row][col + 1] | val;
        }
        // southwest
        if (row + 1 < maxRow && col - 1 >= 0) {
            board[row + 1][col - 1] = board[row + 1][col - 1] | val;
        }
        // south
        if (row + 1 < maxRow) {
            board[row + 1][col] = board[row + 1][col] | val;
        }
        // southeast
        if (row + 1 < maxRow && col + 1 < maxCol) {
            board[row + 1][col + 1] = board[row + 1][col + 1] | val;
        }
    }

    private void print(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    public static void main(String[] args) {
        Problem289 prob = new Problem289();
//        int[][] board = new int[][]{
//            new int[]{1, 0, 0},
//            new int[]{1, 0, 0},
//            new int[]{1, 1, 1},
//        };
//        int[][] board = new int[][]{
//            new int[]{1},
//        };
        int[][] board = new int[][]{
            new int[]{0, 0, 0, 0},
            new int[]{0, 1, 1, 0},
            new int[]{0, 1, 1, 0},
            new int[]{0, 0, 0, 0},
        };
        prob.gameOfLife(board);
        prob.print(board);
    }
}
