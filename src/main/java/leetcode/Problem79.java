package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-search/
 */
public class Problem79 {
    public boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (word.charAt(0) == board[row][col]) {
                    Set<String> set = new HashSet<>();
                    boolean found = exist(board, word, board.length, board[row].length,
                        set, 0, row, col);
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
        set.add(key);
        // left
        boolean a = exist(board, word, maxRow, maxCol, set, idx + 1, row, col - 1);
        // up
        boolean b = exist(board, word, maxRow, maxCol, set, idx + 1, row - 1, col);
        // right
        boolean c = exist(board, word, maxRow, maxCol, set, idx + 1, row, col + 1);
        // down
        boolean d = exist(board, word, maxRow, maxCol, set, idx + 1, row + 1, col);
        boolean result = a | b | c | d;
        if (!result) {
            set.remove(key);
        }
        return result;
    }
}
