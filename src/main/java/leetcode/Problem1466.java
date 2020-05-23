package leetcode;

/**
 * https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
 */
public class Problem1466 {
    public int minReorder(int n, int[][] connections) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1466 prob = new Problem1466();
        System.out.println(prob.minReorder(
            6, new int[][]{{0,1},{1,3},{2,3},{4,0},{4,5}})); // 3
        System.out.println(prob.minReorder(
            5, new int[][]{{1,0},{1,2},{3,2},{3,4}})); // 2
        System.out.println(prob.minReorder(
            3, new int[][]{{1,0},{2,0}})); // 0
    }
}
