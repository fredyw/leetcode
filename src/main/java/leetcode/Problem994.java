package leetcode;

/**
 * https://leetcode.com/problems/rotting-oranges/
 */
public class Problem994 {
    public int orangesRotting(int[][] grid) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem994 prob = new Problem994();
        System.out.println(prob.orangesRotting(new int[][]{
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        })); // 4
        System.out.println(prob.orangesRotting(new int[][]{
            {2, 1, 1},
            {0, 1, 1},
            {1, 0, 1}
        })); // -1
        System.out.println(prob.orangesRotting(new int[][]{
            {0, 2}
        })); // 0
    }
}
