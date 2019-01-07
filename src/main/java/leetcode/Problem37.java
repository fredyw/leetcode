package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sudoku-solver/
 */
public class Problem37 {
    public void solveSudoku(char[][] board) {
        // TODO
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
