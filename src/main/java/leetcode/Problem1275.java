package leetcode;

/**
 * https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/
 */
public class Problem1275 {
    public String tictactoe(int[][] moves) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1275 prob = new Problem1275();
        System.out.println(prob.tictactoe(new int[][]{
            {0,0},{2,0},{1,1},{2,1},{2,2}
        })); // "A"
        System.out.println(prob.tictactoe(new int[][]{
            {0,0},{1,1},{0,1},{0,2},{1,0},{2,0}
        })); // "B"
        System.out.println(prob.tictactoe(new int[][]{
            {0,0},{1,1},{2,0},{1,0},{1,2},{2,1},{0,1},{0,2},{2,2}
        })); // "Draw"
        System.out.println(prob.tictactoe(new int[][]{
            {0,0},{1,1}
        })); // "Pending"
    }
}
