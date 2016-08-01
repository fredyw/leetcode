package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/course-schedule/
 */
public class Problem207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int[] array = prerequisites[i];
            int from = array[0];
            int to = array[1];
            if (graph.containsKey(from)) {
                graph.get(from).add(to);
            } else {
                List<Integer> edges = new ArrayList<>();
                edges.add(to);
                graph.put(from, edges);
            }
        }
        return !hasCycle(graph);
    }

    private static class Cycle {
        boolean cycle;
    }

    private boolean hasCycle(Map<Integer, List<Integer>> graph) {
        Map<Integer, Boolean> onStack = new HashMap<>();
        Set<Integer> marked = new HashSet<>();
        Cycle cycle = new Cycle();
        for (int vertex : graph.keySet()) {
            onStack.put(vertex, false);
        }
        for (int vertex : graph.keySet()) {
            if (!marked.contains(vertex)) {
                dfs(graph, vertex, onStack, marked, cycle);
                if (cycle.cycle) {
                    return true;
                }
            }
        }
        return false;
    }

    private void dfs(Map<Integer, List<Integer>> graph, int source,
                     Map<Integer, Boolean> onStack, Set<Integer> marked,
                     Cycle cycle) {
        if (!graph.containsKey(source)) {
            return;
        }
        marked.add(source);
        onStack.put(source, true);
        for (int vertex : graph.get(source)) {
            if (!marked.contains(vertex)) {
                dfs(graph, vertex, onStack, marked, cycle);
            } else {
                if (onStack.get(vertex)) {
                    cycle.cycle = true;
                }
            }
        }
        onStack.put(source, false);
    }
}
