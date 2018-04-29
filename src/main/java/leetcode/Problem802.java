package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-eventual-safe-states/
 */
public class Problem802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            boolean[] visited = new boolean[10000];
            boolean[] onStack = new boolean[10000];
            Cycle cycle = new Cycle();
            dfs(graph, i, visited, onStack, cycle);
            if (!cycle.cycle) {
                result.add(i);
            }
        }
        return result;
    }

    private static class Cycle {
        private boolean cycle;
    }

    private static void dfs(int[][] graph, int source, boolean[] visited,
                            boolean[] onStack, Cycle cycle) {
        visited[source] = true;
        onStack[source] = true;
        for (int neighbor : graph[source]) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited, onStack, cycle);
            } else {
                if (onStack[neighbor]) {
                    cycle.cycle = true;
                }
            }
        }
        onStack[source] = false;
    }

    public static void main(String[ ] args) {
        Problem802 prob = new Problem802();
        System.out.println(prob.eventualSafeNodes(new int[][]{
            {1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}
        })); // [2,4,5,6]
        System.out.println(prob.eventualSafeNodes(new int[][]{
            {1, 2}, {1}, {0}
        })); // []
    }
}
