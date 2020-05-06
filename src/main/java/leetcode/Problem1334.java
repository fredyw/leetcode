package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
 */
public class Problem1334 {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<Edge>[] adjList = new List[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList();
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            adjList[from].add(new Edge(to, weight));
            adjList[to].add(new Edge(from, weight));
        }
        int answer = -1;
        int min = Integer.MAX_VALUE;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            Set<Integer> cities = new HashSet<>();
            dfs(adjList, i, visited, 0, distanceThreshold, cities);
            if (min > cities.size()) {
                min = cities.size();
                answer = i;
            } else if (min == cities.size()) {
                answer = Math.max(answer, i);
            }
        }
        return answer;
    }

    private static void dfs(List<Edge>[] adjList,
                            int node,
                            boolean[] visited,
                            int weightSum,
                            int distanceThreshold,
                            Set<Integer> cities) {
        if (visited[node]) {
            return;
        }
        if (weightSum <= distanceThreshold) {
            cities.add(node);
        }
        visited[node] = true;
        for (Edge neighbors : adjList[node]) {
            dfs(adjList, neighbors.to, visited, weightSum + neighbors.weight,
                distanceThreshold, cities);
        }
        visited[node] = false;
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
        Problem1334 prob = new Problem1334();
        System.out.println(prob.findTheCity(4, new int[][]{
            {0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1},
        }, 4)); // 3
        System.out.println(prob.findTheCity(5, new int[][]{
            {0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1},
        }, 2)); // 0
    }
}
