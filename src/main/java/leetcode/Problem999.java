package leetcode;

/**
 * https://leetcode.com/problems/available-captures-for-rook/
 */
public class Problem999 {
    public int numRookCaptures(char[][] board) {
        int answer = 0;
        int maxRow = board.length;
        int maxCol = maxRow > 0 ? board[0].length : 0;
        outer:
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                if (board[i][j] == 'R') {
                    // up
                    for (int k = i - 1; k >= 0; k--) {
                        if (board[k][j] == '.') {
                            continue;
                        }
                        if (board[k][j] == 'p') {
                            answer++;
                        }
                        break;
                    }
                    // right
                    for (int k = j + 1; k < maxCol; k++) {
                        if (board[i][k] == '.') {
                            continue;
                        }
                        if (board[i][k] == 'p') {
                            answer++;
                        }
                        break;
                    }
                    // down
                    for (int k = i + 1; k < maxRow; k++) {
                        if (board[k][j] == '.') {
                            continue;
                        }
                        if (board[k][j] == 'p') {
                            answer++;
                        }
                        break;
                    }
                    // left
                    for (int k = j - 1; k >= 0; k--) {
                        if (board[i][k] == '.') {
                            continue;
                        }
                        if (board[i][k] == 'p') {
                            answer++;
                        }
                        break;
                    }
                    break outer;
                }
            }
        }
        return answer;
    }
}
