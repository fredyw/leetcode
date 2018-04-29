package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-eventual-safe-states/
 */
public class Problem802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] onStack = new boolean[graph.length];
        boolean[] visited = new boolean[graph.length];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            boolean cycle = hasCycle(graph, i, visited, onStack);
            if (!cycle) {
                result.add(i);
            }
        }
        return result;
    }

    private static boolean hasCycle(int[][] graph, int source, boolean[] visited,
                                    boolean[] onStack) {
        visited[source] = true;
        onStack[source] = true;
        for (int neighbor : graph[source]) {
            if (!visited[neighbor]) {
                boolean cycle = hasCycle(graph, neighbor, visited, onStack);
                if (cycle) {
                    return true;
                }
            } else {
                if (onStack[neighbor]) {
                    return true;
                }
            }
        }
        onStack[source] = false;
        return false;
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
