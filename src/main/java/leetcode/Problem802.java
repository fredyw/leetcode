package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/find-eventual-safe-states/
 */
public class Problem802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        boolean[] ignored = new boolean[10000];
        for (int i = 0; i < graph.length; i++) {
            if (ignored[i]) {
                continue;
            }
            boolean[] visited = new boolean[10000];
            boolean[] onStack = new boolean[10000];
            boolean cycle = hasCycle(graph, i, visited, onStack);
            if (!cycle) {
                for (int j = 0; j < visited.length; j++) {
                    if (visited[j] && !ignored[j]) {
                        ignored[j] = true;
                        result.add(j);
                    }
                }
            } else {
                for (int j = 0; j < onStack.length; j++) {
                    if (onStack[j]) {
                        ignored[j] = true;
                    }
                }
            }
        }
        Collections.sort(result);
        return result;
    }

    private static boolean hasCycle(int[][] graph, int source, boolean[] visited,
                                    boolean[] onStack) {
        visited[source] = true;
        onStack[source] = true;
        boolean cycle = false;
        for (int neighbor : graph[source]) {
            if (!visited[neighbor]) {
                cycle |= hasCycle(graph, neighbor, visited, onStack);
            } else {
                if (onStack[neighbor]) {
                    return true;
                }
            }
        }
        onStack[source] = false;
        return cycle;
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
