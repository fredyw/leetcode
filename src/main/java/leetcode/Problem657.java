package leetcode;

/**
 * https://leetcode.com/problems/judge-route-circle/
 */
public class Problem657 {
    public boolean judgeCircle(String moves) {
        int row = 0;
        int col = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'U') {
                row--;
            } else if (moves.charAt(i) == 'D') {
                row++;
            } else if (moves.charAt(i) == 'L') {
                col--;
            } else if (moves.charAt(i) == 'R') {
                col++;
            }
        }
        return row == 0 && col == 0;
    }
}
