package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-height-trees/
 */
public class Problem310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n <= 1) {
            return Arrays.asList(0);
        }
        Map<Integer, Set<Integer>> adjList = buildAdjList(edges);
        while (adjList.size() > 2) {
            List<Integer> removedNodes = new ArrayList<>();
            for (Map.Entry<Integer, Set<Integer>> e : adjList.entrySet()) {
                if (e.getValue().size() == 1) {
                    removedNodes.add(e.getKey());
                }
            }
            for (int i : removedNodes) {
                for (int j : adjList.get(i)) {
                    adjList.get(j).remove(i);
                }
                adjList.remove(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        result.addAll(adjList.keySet());
        return result;
    }

    private Map<Integer, Set<Integer>> buildAdjList(int[][] edges) {
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            if (!adjList.containsKey(x)) {
                Set<Integer> set = new HashSet<>();
                set.add(y);
                adjList.put(x, set);
            } else {
                adjList.get(x).add(y);
            }

            if (!adjList.containsKey(y)) {
                Set<Integer> set = new HashSet<>();
                set.add(x);
                adjList.put(y, set);
            } else {
                adjList.get(y).add(x);
            }
        }
        return adjList;
    }
}
