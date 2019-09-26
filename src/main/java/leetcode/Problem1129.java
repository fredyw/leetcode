package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/shortest-path-with-alternating-colors/
 */
public class Problem1129 {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1129 prob = new Problem1129();
        System.out.println(Arrays.toString(prob.shortestAlternatingPaths(3,
            new int[][]{{0, 1}, {1, 2}}, new int[][]{}))); // [0,1,-1]
        System.out.println(Arrays.toString(prob.shortestAlternatingPaths(3,
            new int[][]{{0, 1}}, new int[][]{{2, 1}}))); // [0,1,-1]
        System.out.println(Arrays.toString(prob.shortestAlternatingPaths(3,
            new int[][]{{1, 0}}, new int[][]{{2, 1}}))); // [0,-1,-1]
        System.out.println(Arrays.toString(prob.shortestAlternatingPaths(3,
            new int[][]{{0, 1}}, new int[][]{{1, 2}}))); // [0,1,2]
        System.out.println(Arrays.toString(prob.shortestAlternatingPaths(3,
            new int[][]{{0, 1}, {0, 2}}, new int[][]{{1, 0}}))); // [0,1,1]
    }
}
