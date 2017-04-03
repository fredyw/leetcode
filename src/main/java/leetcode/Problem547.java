package leetcode;

/**
 * https://leetcode.com/problems/friend-circles/
 */
public class Problem547 {
    public int findCircleNum(int[][] M) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem547 prob = new Problem547();

        System.out.println(prob.findCircleNum(new int[][]{
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        })); // 2

        System.out.println(prob.findCircleNum(new int[][]{
            {1, 1, 0},
            {1, 1, 1},
            {0, 1, 1}
        })); // 1
    }
}
