package leetcode;

/**
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/
 */
public class Problem1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1091 prob = new Problem1091();
        System.out.println(prob.shortestPathBinaryMatrix(new int[][]{
            {0, 1},
            {1, 0}
        })); // 2
        System.out.println(prob.shortestPathBinaryMatrix(new int[][]{
            {0, 0, 0},
            {1, 1, 0},
            {1, 1, 0}
        })); // 2
    }
}
