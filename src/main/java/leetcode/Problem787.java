package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 */
public class Problem787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        List<Edge>[] graph = buildGraph(flights);
        int price = findCheapestPrice(graph, src, dst, K + 1, new Integer[100][K + 2]);
        return price == Integer.MAX_VALUE ? - 1 : price;
    }

    private static int findCheapestPrice(List<Edge>[] graph, int src, int dst, int k,
                                         Integer[][] memo) {
        if (k < 0) {
            return Integer.MAX_VALUE;
        }
        if (src == dst) {
            return 0;
        }
        if (memo[src][k] != null) {
            return memo[src][k];
        }
        List<Edge> neighbors = graph[src];
        if (neighbors == null) {
            return Integer.MAX_VALUE;
        }
        int min = Integer.MAX_VALUE;
        for (Edge neighbor : neighbors) {
            int price = findCheapestPrice(graph, neighbor.to, dst, k - 1, memo);
            if (price != Integer.MAX_VALUE) {
                min = Math.min(min, price + neighbor.price);
            }
        }
        if (min != Integer.MAX_VALUE) {
            memo[src][k] = min;
        }
        return min;
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
        private final int price;

        public Edge(int to, int price) {
            this.to = to;
            this.price = price;
        }
    }
}
