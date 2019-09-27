package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

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
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, red, 0));
        while (!queue.isEmpty()) {
            Node current = queue.remove();
            if (visited.contains(current)) {
                continue;
            }
            List<Integer>[] adjList = current.red ? blueAdjList : redAdjList; // alternate
            List<Integer> neighbors = adjList[current.node];
            counts[current.node] = counts[current.node] == null ?
                current.count : Math.min(counts[current.node], current.count);
            visited.add(current);
            if (neighbors != null) {
                for (int neighbor : neighbors) {
                    Node node = new Node(neighbor, !current.red, current.count + 1);
                    if (visited.contains(node)) {
                        continue;
                    }
                    queue.add(node);
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node1 = (Node) o;
            return node == node1.node &&
                red == node1.red;
        }

        @Override
        public int hashCode() {
            return Objects.hash(node, red);
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
}
