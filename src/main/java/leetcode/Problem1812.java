package leetcode;

/**
 * https://leetcode.com/problems/determine-color-of-a-chessboard-square/
 */
public class Problem1812 {
    public boolean squareIsWhite(String coordinates) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem1812 prob = new Problem1812();
        System.out.println(prob.squareIsWhite("a1")); // false
        System.out.println(prob.squareIsWhite("h3")); // true
        System.out.println(prob.squareIsWhite("c7")); // false
    }
}
