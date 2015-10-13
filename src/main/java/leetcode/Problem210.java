package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/course-schedule-ii/
 */
public class Problem210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Set<Integer> vertices = new HashSet<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int[] array = prerequisites[i];
            if (array.length != 2) {
                continue;
            }
            int from = array[0];
            int to = array[1];
            if (adjList.containsKey(from)) {
                adjList.get(from).add(to);
            } else {
                List<Integer> edges = new ArrayList<>();
                edges.add(to);
                adjList.put(from, edges);
            }
        }
        for (int i = 0; i < numCourses; i++) {
            vertices.add(i);
        }
        boolean cycle = hasCycle(adjList);
        if (cycle) {
            return new int[]{};
        }
        List<Integer> path = topologicalSort(adjList, vertices);
        int[] result = new int[path.size()];
        for (int i = 0; i < path.size(); i++) {
            result[i] = path.get(i);
        }
        return result;
    }

    private List<Integer> topologicalSort(Map<Integer, List<Integer>> adjList,
                                          Set<Integer> vertices) {
        Set<Integer> marked = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        for (int vertex : vertices) {
            if (!marked.contains(vertex)) {
                topologicalSort(adjList, vertex, marked, path);
            }
        }
        return path;
    }

    private void topologicalSort(Map<Integer, List<Integer>> adjList, int source,
                                 Set<Integer> marked, List<Integer> path) {
        marked.add(source);
        if (adjList.containsKey(source)) {
            for (int vertex : adjList.get(source)) {
                if (!marked.contains(vertex)) {
                    topologicalSort(adjList, vertex, marked, path);
                }
            }
        }
        path.add(source);
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
                hasCycle(graph, vertex, onStack, marked, cycle);
                if (cycle.cycle) {
                    return true;
                }
            }
        }
        return false;
    }

    private void hasCycle(Map<Integer, List<Integer>> graph, int source,
                          Map<Integer, Boolean> onStack, Set<Integer> marked,
                          Cycle cycle) {
        if (!graph.containsKey(source)) {
            return;
        }
        marked.add(source);
        onStack.put(source, true);
        for (int vertex : graph.get(source)) {
            if (!marked.contains(vertex)) {
                hasCycle(graph, vertex, onStack, marked, cycle);
            } else {
                if (onStack.get(vertex)) {
                    cycle.cycle = true;
                }
            }
        }
        onStack.put(source, false);
    }
}
