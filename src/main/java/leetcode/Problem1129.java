package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/shortest-path-with-alternating-colors/
 */
public class Problem1129 {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        Set<Integer>[] redAdjList = buildGraph(n, red_edges);
        Set<Integer>[] blueAdjList = buildGraph(n, blue_edges);
        int[] answer = new int[n];
        return answer;
    }

    private static Set<Integer>[] buildGraph(int n, int[][] edges) {
        Set<Integer>[] graph = new Set[n];
        for (int i = 0; i < n; i++) {
            for (int[] edge : edges) {
                int from = edge[0];
                int to = edge[1];
                if (graph[from] == null) {
                    graph[from] = new HashSet<>();
                }
                graph[from].add(to);
            }
        }
        return graph;
    }

    public static void main(String[] args) {
        Problem1129 prob = new Problem1129();
//        System.out.println(Arrays.toString(prob.shortestAlternatingPaths(3,
//            new int[][]{{0, 1}, {1, 2}}, new int[][]{}))); // [0,1,-1]
//        System.out.println(Arrays.toString(prob.shortestAlternatingPaths(3,
//            new int[][]{{0, 1}}, new int[][]{{2, 1}}))); // [0,1,-1]
//        System.out.println(Arrays.toString(prob.shortestAlternatingPaths(3,
//            new int[][]{{1, 0}}, new int[][]{{2, 1}}))); // [0,-1,-1]
//        System.out.println(Arrays.toString(prob.shortestAlternatingPaths(3,
//            new int[][]{{0, 1}}, new int[][]{{1, 2}}))); // [0,1,2]
//        System.out.println(Arrays.toString(prob.shortestAlternatingPaths(3,
//            new int[][]{{0, 1}, {0, 2}}, new int[][]{{1, 0}}))); // [0,1,1]
        System.out.println(Arrays.toString(prob.shortestAlternatingPaths(4,
            new int[][]{{0, 1}, {1, 2}, {3, 2}}, new int[][]{{1, 3}}))); // [0,1,3,2]
    }
}
