package leetcode;

/**
 * https://leetcode.com/problems/minesweeper/
 */
public class Problem529 {
    public char[][] updateBoard(char[][] board, int[] click) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem529 prob = new Problem529();

        // [['B', '1', 'E', '1', 'B'],
        // ['B', '1', 'X', '1', 'B'],
        // ['B', '1', '1', '1', 'B'],
        // ['B', 'B', 'B', 'B', 'B']]
        char[][] chars = prob.updateBoard(new char[][]{
            {'B', '1', 'E', '1', 'B'},
            {'B', '1', 'M', '1', 'B'},
            {'B', '1', '1', '1', 'B'},
            {'B', 'B', 'B', 'B', 'B'}
        }, new int[]{1, 2});
    }
}
