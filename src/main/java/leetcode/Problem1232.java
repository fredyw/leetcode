package leetcode;

/**
 * https://leetcode.com/problems/check-if-it-is-a-straight-line/
 */
public class Problem1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem1232 prob = new Problem1232();
        System.out.println(prob.checkStraightLine(new int[][]{
            {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}
        })); // true
        System.out.println(prob.checkStraightLine(new int[][]{
            {1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}
        })); // false
    }
}
