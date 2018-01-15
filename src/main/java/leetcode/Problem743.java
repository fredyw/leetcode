package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/network-delay-time/
 */
public class Problem743 {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int[] edge: times) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<>());
            }
            graph.get(edge[0]).add(new Edge(edge[1], edge[2]));
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));
        pq.add(new Edge(K, 0));

        Map<Integer, Integer> dist = new HashMap<>();

        while (!pq.isEmpty()) {
            Edge edge = pq.remove();
            if (dist.containsKey(edge.node)) {
                continue;
            }
            dist.put(edge.node, edge.weight);
            if (graph.containsKey(edge.node)) {
                for (Edge e : graph.get(edge.node)) {
                    if (!dist.containsKey(e.node)) {
                        pq.add(new Edge(e.node, edge.weight + e.weight));
                    }
                }
            }
        }

        if (dist.size() != N) {
            return -1;
        }
        int result = 0;
        for (int val : dist.values()) {
            result = Math.max(result, val);
        }
        return result;
    }

    private static class Edge {
        private final int node;
        private final int weight;

        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}
