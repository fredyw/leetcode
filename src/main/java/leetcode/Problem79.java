package leetcode;

/**
 * https://leetcode.com/problems/word-search/
 */
public class Problem79 {
    public boolean exist(char[][] board, String word) {
        int maxRow = board.length;
        int maxCol = maxRow > 0 ? board[0].length : 0;
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                boolean[][] visited = new boolean[maxRow][maxCol];
                if (exist(board, word, maxRow, maxCol, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean exist(char[][] board, String word, int maxRow, int maxCol,
                                 int idx, int row, int col, boolean[][] visited) {
        if (idx == word.length()) {
            return true;
        }
        if (row < 0 || row == maxRow || col < 0 || col == maxCol) {
            return false;
        }
        if (visited[row][col]) {
            return false;
        }
        char c = word.charAt(idx);
        if (board[row][col] != c) {
            return false;
        }
        visited[row][col] = true;
        boolean answer = false;
        answer |= exist(board, word, maxRow, maxCol, idx + 1, row, col + 1, visited); // right
        answer |= exist(board, word, maxRow, maxCol, idx + 1, row + 1, col, visited); // down
        answer |= exist(board, word, maxRow, maxCol, idx + 1, row, col - 1, visited); // left
        answer |= exist(board, word, maxRow, maxCol, idx + 1, row - 1, col, visited); // up
        visited[row][col] = false;
        return answer;
    }
}
