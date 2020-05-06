package leetcode;

import java.util.Arrays;

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
        int answer = 0;
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
        for (int[] edge : graph) {
            System.out.println(Arrays.toString(edge));
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem1334 prob = new Problem1334();
        System.out.println(prob.findTheCity(4, new int[][]{
            {0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1},
        }, 4)); // 3
//        System.out.println(prob.findTheCity(5, new int[][]{
//            {0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1},
//        }, 2)); // 0
    }
}
