package leetcode;

/**
 * https://leetcode.com/problems/determine-color-of-a-chessboard-square/
 */
public class Problem1812 {
    public boolean squareIsWhite(String coordinates) {
        return squareIsWhite(
            (coordinates.charAt(0) - 'a') + 1,
            (coordinates.charAt(1) - '0') + 1);
    }

    private static boolean squareIsWhite(int row, int col) {
        if (row % 2 == 0) {
            return col % 2 == 0;
        }
        return col % 2 != 0;
    }
}
