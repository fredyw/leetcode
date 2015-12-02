package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/minimum-height-trees/
 */
public class Problem310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n <= 1) {
            return new ArrayList<>();
        }
        Map<Integer, List<Integer>> adjList = buildAdjList(edges);
        TreeMap<Integer, List<Integer>> result = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            int height = countHeight(i, adjList, visited, 0);
            if (!result.containsKey(height)) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                result.put(height, list);
            } else {
                result.get(height).add(i);
            }
        }
        return result.firstEntry().getValue();
    }

    private int countHeight(int node, Map<Integer, List<Integer>> adjList, boolean[] visited,
                            int accu) {
        visited[node] = true;
        int maxHeight = accu;
        for (int n : adjList.get(node)) {
            if (!visited[n]) {
                int height = countHeight(n, adjList, visited, accu + 1);
                maxHeight = Math.max(maxHeight, height);
            }
        }
        return maxHeight;
    }

    private Map<Integer, List<Integer>> buildAdjList(int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            if (!adjList.containsKey(x)) {
                List<Integer> list = new ArrayList<>();
                list.add(y);
                adjList.put(x, list);
            } else {
                adjList.get(x).add(y);
            }

            if (!adjList.containsKey(y)) {
                List<Integer> list = new ArrayList<>();
                list.add(x);
                adjList.put(y, list);
            } else {
                adjList.get(y).add(x);
            }
        }
        return adjList;
    }

    public static void main(String[] args) {
        Problem310 prob = new Problem310();
        System.out.println(prob.findMinHeightTrees(4, new int[][]{
            {1, 0}, {1, 2}, {1, 3}
        })); // 1
        System.out.println(prob.findMinHeightTrees(6, new int[][]{
            {0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}
        })); // 3, 4
        System.out.println(prob.findMinHeightTrees(7, new int[][]{
            {0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}, {0, 6}
        })); // 3
        System.out.println(prob.findMinHeightTrees(1, new int[][]{
        })); // 0
    }
}
