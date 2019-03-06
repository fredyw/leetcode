package leetcode;

/**
 * https://leetcode.com/problems/valid-tic-tac-toe-state/
 */
public class Problem794 {
    public boolean validTicTacToe(String[] board) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem794 prob = new Problem794();
        System.out.println(prob.validTicTacToe(new String[]{"O  ", "   ", "   "})); // false
        System.out.println(prob.validTicTacToe(new String[]{"XOX", " X ", "   "})); // false
        System.out.println(prob.validTicTacToe(new String[]{"XXX", "   ", "OOO"})); // false
        System.out.println(prob.validTicTacToe(new String[]{"XOX", "O O", "XOX"})); // true
    }
}
