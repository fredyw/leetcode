package leetcode;

/**
 * https://leetcode.com/problems/snakes-and-ladders/
 */
public class Problem909 {
    public int snakesAndLadders(int[][] board) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem909 prob = new Problem909();
        System.out.println(prob.snakesAndLadders(new int[][]{
            {-1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1},
            {-1, 35, -1, -1, 13, -1},
            {-1, -1, -1, -1, -1, -1},
            {-1, 15, -1, -1, -1, -1}
        })); // 4
    }
}
