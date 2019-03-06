package leetcode;

/**
 * https://leetcode.com/problems/valid-tic-tac-toe-state/
 */
public class Problem794 {
    public boolean validTicTacToe(String[] board) {
        int oCount = 0;
        int xCount = 0;
        for (int i = 0; i < board.length; i++) {
            char[] chars = board[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == 'O') {
                    oCount++;
                } else if (chars[j] == 'X') {
                    xCount++;
                }
            }
        }
        if (xCount - oCount != 1 && xCount - oCount != 0) {
            return false;
        }
        // Check for winning states.
        String leftDiag = "";
        String rightDiag = "";
        for (int i = 0; i < board.length; i++) {
            if (board[i].equals("XXX") || board[i].equals("OOO")) {
                if (!isValid(board[i], xCount, oCount)) {
                    return false;
                }
            }
            String s = "";
            for (int j = 0; j < board.length; j++) {
                s += board[j].charAt(i);
            }
            if (s.equals("XXX") || s.equals("OOO")) {
                if (!isValid(s, xCount, oCount)) {
                    return false;
                }
            }
            leftDiag += board[i].charAt(i);
            rightDiag += board[i].charAt(board.length - i - 1);
        }
        if (leftDiag.equals("XXX") || leftDiag.equals("OOO")) {
            if (!isValid(leftDiag, xCount, oCount)) {
                return false;
            }
        }
        if (rightDiag.equals("XXX") || rightDiag.equals("OOO")) {
            if (!isValid(rightDiag, xCount, oCount)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValid(String winning, int xCount, int oCount) {
        if (winning.equals("XXX")) {
            if (xCount - oCount != 1) {
                return false;
            }
        } else if (winning.equals("OOO")) {
            if (xCount != oCount) {
                return false;
            }
        }
        return true;
    }
}
