package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 */
public class Problem787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        List<Edge>[] graph = buildGraph(flights);
        Queue<NodeCount> queue = new LinkedList<>();
        queue.add(new NodeCount(src, -1, 0));
        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            NodeCount current = queue.remove();
            if (current.node == dst) {
                min = Math.min(min, current.weight);
            }
            List<Edge> neighbors = graph[current.node];
            if (neighbors == null) {
                continue;
            }
            for (Edge edge : neighbors) {
                if (current.count + 1 <= K) {
                    queue.add(new NodeCount(edge.to, current.count + 1,
                        current.weight + edge.weight));
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private static class NodeCount {
        private final int node;
        private final int count;
        private final int weight;

        public NodeCount(int node, int count, int weight) {
            this.node = node;
            this.count = count;
            this.weight = weight;
        }
    }

    private static List<Edge>[] buildGraph(int[][] flights) {
        List<Edge>[] graph = new List[100];
        for (int i = 0; i < flights.length; i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            int w = flights[i][2];
            if (graph[u] == null) {
                List<Edge> list = new ArrayList<>();
                list.add(new Edge(v, w));
                graph[u] = list;
            } else {
                graph[u].add(new Edge(v, w));
            }
        }
        return graph;
    }

    private static class Edge {
        private final int to;
        private final int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Problem787 prob = new Problem787();
        System.out.println(prob.findCheapestPrice(3, new int[][]{
            {0, 1, 100}, {1, 2, 100}, {0, 2, 500}
        }, 0, 2, 1)); // 20
        System.out.println(prob.findCheapestPrice(3, new int[][]{
            {0, 1, 100}, {1, 2, 100}, {0, 2, 500}
        }, 0, 2, 0)); // 500
    }
}
