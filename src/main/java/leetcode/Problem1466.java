package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
 */
public class Problem1466 {
    public int minReorder(int n, int[][] connections) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        Set[] direction = new Set[n];
        for (int i = 0; i < n; i++) {
            direction[i] = new HashSet();
        }
        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            graph[from].add(to);
            graph[to].add(from);
            direction[from].add(to);
        }
        return minReorder(graph, new boolean[n], direction, 0);
    }

    private static int minReorder(List<Integer>[] graph, boolean[] visited,
                                  Set[] direction, int node) {
        int count = 0;
        visited[node] = true;
        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                if (direction[node].contains(neighbor)) {
                    count++;
                }
                count += minReorder(graph, visited, direction, neighbor);
            }
        }
        return count;
    }
}
