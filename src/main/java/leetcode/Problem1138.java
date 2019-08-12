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
            int srcRow = (src - 'a') / 5;
            int srcCol = (src - 'a') % 5;
            int destRow = (dest - 'a') / 5;
            int destCol = (dest - 'a') % 5;

            int row = destRow - srcRow;
            int col = destCol - srcCol;
            answer += buildPath(row, col);
        }
        return answer;
    }

    private static String buildPath(int row, int col) {
        String path  = "";
        if (row < 0) {
            for (int i = row; i < 0; i++) {
                path += "U";
            }
        } else if (row > 0) {
            for (int i = 0; i < row; i++) {
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
        return path + "!";
    }

    public static void main(String[] args) {
        Problem1138 prob = new Problem1138();
//        System.out.println(prob.alphabetBoardPath("leet")); // "DDR!UURRR!!DDD!"
//        System.out.println(prob.alphabetBoardPath("code")); // "RR!DDRR!UUL!R!"
        System.out.println(prob.alphabetBoardPath("zdz")); // "DDDDD!UUUUURRR!DDDDLLLD!"
    }
}