package leetcode;

/**
 * https://leetcode.com/problems/battleships-in-a-board/
 */
public class Problem419 {
    public int countBattleships(char[][] board) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem419 prob = new Problem419();
        System.out.println(prob.countBattleships(new char[][]{
            new String("X..X").toCharArray(),
            new String("...X").toCharArray(),
            new String("...X").toCharArray()
        })); // 2
    }
}
