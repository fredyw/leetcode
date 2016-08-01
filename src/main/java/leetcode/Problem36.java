package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://oj.leetcode.com/problems/valid-sudoku/
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
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                if (!rowMap.containsKey(i)) {
                    rowMap.put(i, new HashSet<>());
                }
                if (!colMap.containsKey(j)) {
                    colMap.put(j, new HashSet<>());
                }
                Set<Character> rowSet = rowMap.get(i);
                if (rowSet.contains(c)) {
                    return false;
                } else {
                    rowSet.add(c);
                }
                Set<Character> colSet = colMap.get(j);
                if (colSet.contains(c)) {
                    return false;
                } else {
                    colSet.add(c);
                }
            }
        }
        return true;
    }

    private boolean isValidSudokuSubGrid(char[][] board, int startRow, int endRow,
                                         int startCol, int endCol) {
        Set<Character> set = new HashSet<>();
        for (int i = startRow; i < endRow; i++) {
            for (int j = startCol; j < endCol; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                if (set.contains(c)) {
                    return false;
                } else {
                    set.add(c);
                }
            }
        }
        return true;
    }
}
