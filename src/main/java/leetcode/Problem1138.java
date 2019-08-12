package leetcode;

/**
 * https://leetcode.com/problems/alphabet-board-path/
 */
public class Problem1138 {
    public String alphabetBoardPath(String target) {
        String answer = "";
        target = "a" + target; // start from (0, 0)
        for (int i = 0; i < target.length() - 1; i++) {
            char src = target.charAt(i);
            char dest = target.charAt(i + 1);
            if (src == dest) {
                answer += "!";
            } else {
                int srcRow = (src - 'a') / 5;
                int srcCol = (src - 'a') % 5;
                int destRow = (dest - 'a') / 5;
                int destCol = (dest - 'a') % 5;

                int row = destRow - srcRow;
                int col = destCol - srcCol;
                answer += buildPath(row, col, destRow == 5 /* is z */);
            }
        }
        return answer;
    }

    private static String buildPath(int row, int col, boolean isZ) {
        String path  = "";
        if (row < 0) {
            for (int i = row; i < 0; i++) {
                path += "U";
            }
        } else if (row > 0) {
            for (int i = 0; i < (isZ ? row - 1 : row); i++) {
                path += "D";
            }
        }

        if (col < 0) {
            for (int i = col; i < 0; i++) {
                path += "L";
            }
        } else if (col > 0) {
            for (int i = 0; i < col; i++) {
                path += "R";
            }
        }
        if (isZ) {
            path += "D";
        }
        return path + "!";
    }
}