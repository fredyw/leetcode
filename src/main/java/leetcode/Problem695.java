package leetcode;

/**
 * https://leetcode.com/problems/max-area-of-island/
 */
public class Problem695 {
    public int maxAreaOfIsland(int[][] grid) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem695 prob = new Problem695();
        System.out.println(prob.maxAreaOfIsland(new int[][]{
            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        })); // 6
        System.out.println(prob.maxAreaOfIsland(new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0}
        })); // 0
    }
}
