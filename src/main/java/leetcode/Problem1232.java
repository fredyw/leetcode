package leetcode;

/**
 * https://leetcode.com/problems/check-if-it-is-a-straight-line/
 */
public class Problem1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        for (int i = 0; i < coordinates.length - 2; i++) {
            if (!isColiner(
                coordinates[i][0], coordinates[i][1],
                coordinates[i + 1][0], coordinates[i + 1][1],
                coordinates[i + 2][0], coordinates[i + 2][1])) {
                return false;
            }
        }
        return true;
    }

    private static boolean isColiner(int x1, int y1, int x2, int y2, int x3, int y3) {
        // https://math.stackexchange.com/questions/701862/how-to-find-if-the-points-fall-in-a-straight-line-or-not
        return (y2 - y1) * (x3 - x1) == (y3 - y1) * (x2 - x1);
    }
}
