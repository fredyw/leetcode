package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/course-schedule/
 */
public class Problem207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List[] graph = new List[numCourses];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList();
        }
        for (int[] preq : prerequisites) {
            graph[preq[1]].add(preq[0]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] onStack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i]) {
                continue;
            }
            if (!hasCycle(graph, visited, onStack, i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasCycle(List[] graph, boolean[] visited, boolean[] onStack, int n) {
        List<Integer> neighbors = graph[n];
        onStack[n] = true;
        visited[n] = true;
        for (int adj : neighbors) {
            if (!visited[adj]) {
                if (!hasCycle(graph, visited, onStack, adj)) {
                    return false;
                }
            } else {
                if (onStack[adj]) {
                    return false;
                }
            }
        }
        onStack[n] = false;
        return true;
    }
}
