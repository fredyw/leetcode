package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/find-if-path-exists-in-graph/
 */
public class Problem1971 {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        List<Integer>[] adjList = new List[n];
        for (int[] edge : edges) {
            if (adjList[edge[0]] == null) {
                adjList[edge[0]] = new ArrayList<>();
            }
            adjList[edge[0]].add(edge[1]);
            if (adjList[edge[1]] == null) {
                adjList[edge[1]] = new ArrayList<>();
            }
            adjList[edge[1]].add(edge[0]);
        }
        int number = 0;
        int[] groups = new int[n];
        Arrays.fill(groups, -1);
        for (int i = 0; i < n; i++) {
            if (groups[i] != -1) {
                continue;
            }
            traverse(adjList, groups, number++, i);
        }
        return groups[start] == groups[end];
    }

    private static void traverse(List<Integer>[] adjList, int[] groups, int number, int node) {
        groups[node] = number;
        if (adjList[node] == null) {
            return;
        }
        for (int adj : adjList[node]) {
            if (groups[adj] != -1) {
                continue;
            }
            traverse(adjList, groups, number, adj);
        }
    }
}
