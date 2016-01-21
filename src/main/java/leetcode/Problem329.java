package leetcode;

/**
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 */
public class Problem329 {
    public int longestIncreasingPath(int[][] matrix) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem329 prob = new Problem329();
        System.out.println(prob.longestIncreasingPath(new int[][]{
            {9, 9, 4},
            {6, 6, 8},
            {2, 1, 1}
        })); // 4
        System.out.println(prob.longestIncreasingPath(new int[][]{
            {3, 4, 5},
            {3, 2, 6},
            {2, 2, 1}
        })); // 4
    }
}
