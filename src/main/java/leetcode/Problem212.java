package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-search-ii/
 */
public class Problem212 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> answer = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }
        int maxRow = board.length;
        int maxCol = board.length > 0 ? board[0].length : 0;
        outer:
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                boolean[][] visited = new boolean[maxRow][maxCol];
                List<String> tmp = new ArrayList<>();
                for (String word : set) {
                    if (findWords(board, word, maxRow, maxCol, i, j, 0, visited)) {
                        tmp.add(word);
                        answer.add(word);
                    }
                }
                for (String word : tmp) {
                    set.remove(word);
                }
                if (set.isEmpty()) {
                    break outer;
                }
            }
        }
        return answer;
    }

    private static boolean findWords(char[][] board, String word, int maxRow, int maxCol,
                                     int row, int col, int idx, boolean[][] visited) {
        if (idx == word.length()) {
            return true;
        }
        if (row < 0 || row == maxRow || col < 0 || col == maxCol) {
            return false;
        }
        if (visited[row][col]) {
            return false;
        }
        if (board[row][col] != word.charAt(idx)) {
            return false;
        }
        visited[row][col] = true;
        boolean a = findWords(board, word, maxRow, maxCol, row - 1, col, idx + 1, visited);
        boolean b = findWords(board, word, maxRow, maxCol, row, col + 1, idx + 1, visited);
        boolean c = findWords(board, word, maxRow, maxCol, row + 1, col, idx + 1, visited);
        boolean d = findWords(board, word, maxRow, maxCol, row, col - 1, idx + 1, visited);
        visited[row][col] = false; // backtracking
        return a | b | c | d;
    }
}
