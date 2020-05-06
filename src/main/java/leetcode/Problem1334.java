package leetcode;

/**
 * https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
 */
public class Problem1334 {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // https://en.wikipedia.org/wiki/Floyd%E2%80%93Warshall_algorithm
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    graph[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            graph[from][to] = weight;
            graph[to][from] = weight;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][k] != Integer.MAX_VALUE &&
                        graph[k][j] != Integer.MAX_VALUE &&
                        graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
        int answer = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (graph[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if (min > count) {
                min = count;
                answer = i;
            } else if (min == count) {
                answer = Math.max(answer, i);
            }
        }
        return answer;
    }
}
