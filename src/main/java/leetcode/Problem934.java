package leetcode;

/**
 * https://leetcode.com/problems/shortest-bridge/
 */
public class Problem934 {
    public int shortestBridge(int[][] A) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem934 prob = new Problem934();
        System.out.println(prob.shortestBridge(new int[][]{
            {0, 1},
            {1, 0}
        })); // 1
        System.out.println(prob.shortestBridge(new int[][]{
            {0, 1, 0},
            {0, 0, 0},
            {0, 0, 1}
        })); // 2
        System.out.println(prob.shortestBridge(new int[][]{
            {1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1}
        })); // 1
    }
}
