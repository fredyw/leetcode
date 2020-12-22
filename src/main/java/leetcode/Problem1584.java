package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/min-cost-to-connect-all-points/
 */
public class Problem1584 {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int distance =
                    Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                queue.add(new Edge(i, j, distance));
            }
        }
        int answer = 0;
        UnionFind uf = new UnionFind();
        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            if (!uf.connected(edge.from, edge.to)) {
                uf.union(edge.from, edge.to);
                answer += edge.distance;
            }
        }
        return answer;
    }

    private static class Edge {
        private final int from;
        private final int to;
        private final int distance;

        Edge(int from, int to, int distance) {
            this.from = from;
            this.to = to;
            this.distance = distance;
        }
    }

    private static class UnionFind {
        private final Integer[] map = new Integer[1000];

        void union(int a, int b) {
            if (map[a] == null) {
                map[a] = a;
            }
            if (map[b] == null) {
                map[b] = b;
            }
            if (!connected(a, b)) {
                return;
            }
            int value = map[a];
            for (int i = 0; i < map.length; i++) {
                if (map[i] != null) {
                    if (map[i] == value) {
                        map[i] = map[b];
                    }
                }
            }
        }

        boolean connected(int a, int b) {
            if (map[a] == null || map[b] == null) {
                return false;
            }
            return map[a] == map[b];
        }
    }
}
