package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/minimum-height-trees/
 */
public class Problem310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n <= 1) {
            return new ArrayList<>();
        }
        List<Integer>[] adjList = buildAdjList(n, edges);
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

    private int countHeight(int node, List<Integer>[] adjList, boolean[] visited,
                            int accu) {
        visited[node] = true;
        int maxHeight = accu;
        for (int n : adjList[node]) {
            if (!visited[n]) {
                int height = countHeight(n, adjList, visited, accu + 1);
                maxHeight = Math.max(maxHeight, height);
            }
        }
        return maxHeight;
    }

    private List<Integer>[] buildAdjList(int n, int[][] edges) {
        List<Integer>[] adjList = new List[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            adjList[x].add(y);
            adjList[y].add(x);
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
