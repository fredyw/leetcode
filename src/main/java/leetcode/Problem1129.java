package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/shortest-path-with-alternating-colors/
 */
public class Problem1129 {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        List<Integer>[] redAdjList = buildGraph(n, red_edges);
        List<Integer>[] blueAdjList = buildGraph(n, blue_edges);
        int[] answer = new int[n];
        Integer[] redCounts = getCounts(n, redAdjList, blueAdjList, true);
        Integer[] blueCounts = getCounts(n, redAdjList, blueAdjList, false);
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Math.min(
                redCounts[i] == null ? Integer.MAX_VALUE : redCounts[i],
                blueCounts[i] == null ? Integer.MAX_VALUE : blueCounts[i]);
            if (answer[i] == Integer.MAX_VALUE) {
                answer[i] = -1;
            }
        }
        return answer;
    }

    private static Integer[] getCounts(int n,
                                       List<Integer>[] redAdjList,
                                       List<Integer>[] blueAdjList,
                                       boolean red) {
        Integer[] counts = new Integer[n];
        boolean[] visited = new boolean[n];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, red, 0));
        while (!queue.isEmpty()) {
            Node current = queue.remove();
            List<Integer>[] adjList = current.red ? blueAdjList : redAdjList; // alternate
            List<Integer> neighbors = adjList[current.node];
            counts[current.node] = current.count;
            visited[current.node] = true;
            if (neighbors != null) {
                for (int neighbor : neighbors) {
                    if (visited[neighbor]) {
                        continue;
                    }
                    queue.add(new Node(neighbor, !current.red, current.count + 1));
                }
            }
        }
        return counts;
    }

    private static final class Node {
        private final int node;
        private final boolean red;
        private final int count;

        public Node(int node, boolean red, int count) {
            this.node = node;
            this.red = red;
            this.count = count;
        }
    }

    private static List<Integer>[] buildGraph(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            for (int[] edge : edges) {
                int from = edge[0];
                int to = edge[1];
                if (graph[from] == null) {
                    graph[from] = new ArrayList<>();
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
//        System.out.println(Arrays.toString(prob.shortestAlternatingPaths(4,
//            new int[][]{{0, 1}, {1, 2}, {3, 2}}, new int[][]{{1, 3}}))); // [0,1,3,2]
        System.out.println(Arrays.toString(prob.shortestAlternatingPaths(5,
            new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}}, new int[][]{{1, 2}, {2, 3}, {3, 1}}))); // [0,1,2,3,7]
    }
}
