package leetcode;

/**
 * https://leetcode.com/problems/battleships-in-a-board/
 */
public class Problem419 {
    public int countBattleships(char[][] board) {
        boolean[][] marked = new boolean[board.length][board[0].length];
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X' && !marked[i][j]) {
                    marked[i][j] = true;
                    count++;

                    int right = j + 1;
                    while (right < board[i].length && board[i][right] == 'X') {
                        marked[i][right] = true;
                        right++;
                    }

                    int down = i + 1;
                    while (down < board.length && board[down][j] == 'X') {
                        marked[down][j] = true;
                        down++;
                    }
                }
            }
        }
        return count;
    }
}
