package leetcode;

/**
 * https://leetcode.com/problems/surrounded-regions/
 */
public class Problem130 {
    public void solve(char[][] board) {
        // TODO
    }

    public static void main(String[] args) {
        Problem130 prob = new Problem130();
        char[][] board = new char[][]{
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'},
        };
        prob.solve(board);
    }
}
