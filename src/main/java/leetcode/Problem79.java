package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-search/
 */
public class Problem79 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (word.charAt(0) == board[i][j]) {
//                    System.out.println("processing " + i + ", " + j);
                    Set<String> set = new HashSet<>();
                    boolean found = exist(board, word, board.length, board[i].length,
                        set, 0, i, j);
//                    System.out.println("  - found=" + found);
                    if (found) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int maxRow, int maxCol,
                          Set<String> set,
                          int idx, int row, int col) {
        String key = row + "|" + col;
        if (col < 0 || col >= maxCol || row < 0 || row >= maxRow) {
            return false;
        }
        if (idx >= word.length()) {
            return false;
        }
        if (board[row][col] != word.charAt(idx)) {
            return false;
        }
        if (set.contains(key)) {
            return false;
        }
        if (board[row][col] == word.charAt(idx) && idx == word.length() - 1) {
            return true;
        }
//        System.out.println("  - val=" + board[row][col]);
        // left
        Set<String> newSet = new HashSet<>(set);
        newSet.add(key);
        boolean a = exist(board, word, maxRow, maxCol, newSet, idx + 1, row, col - 1);
        // up
        newSet = new HashSet<>(set);
        newSet.add(key);
        boolean b = exist(board, word, maxRow, maxCol, newSet, idx + 1, row - 1, col);
        // right
        newSet = new HashSet<>(set);
        newSet.add(key);
        boolean c = exist(board, word, maxRow, maxCol, newSet, idx + 1, row, col + 1);
        // down
        newSet = new HashSet<>(set);
        newSet.add(key);
        boolean d = exist(board, word, maxRow, maxCol, newSet, idx + 1, row + 1, col);

        return a | b | c | d;
    }

    public static void main(String[] args) {
        Problem79 prob = new Problem79();
//        char[][] board = new char[][]{
//            {'A', 'B', 'C', 'E'},
//            {'S', 'F', 'C', 'S'},
//            {'A', 'D', 'E', 'E'},
//        };
//        System.out.println(prob.exist(board, "ABCCED")); // true
//        System.out.println(prob.exist(board, "SEE")); // true
//        System.out.println(prob.exist(board, "ABCB")); // false

        char[][] board = new char[][]{
            {'a', 'a', 'a', 'a'},
            {'a', 'a', 'a', 'a'},
            {'a', 'a', 'a', 'a'},
            {'a', 'a', 'a', 'a'},
            {'a', 'a', 'a', 'b'},
        };
        System.out.println(prob.exist(board, "aaaaaaaaaaaaaaaaaaaa"));
    }
}
