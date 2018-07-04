package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/loud-and-rich/
 */
public class Problem851 {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        List<Integer>[] graph = buildGraph(richer, quiet.length);
        int[] answers = new int[quiet.length];
        for (int i = 0; i < quiet.length; i++) {
            boolean[] visited = new boolean[quiet.length];
            Quietest quietest = new Quietest();
            dfs(graph, i, visited, quiet, quietest);
            answers[i] = quietest.index;
        }
        return answers;
    }

    private static class Quietest {
        private int value = Integer.MAX_VALUE;
        private int index = -1;
    }

    private static void dfs(List<Integer>[] graph,
                            int source,
                            boolean[] visited,
                            int[] quiet,
                            Quietest quietest) {
        if (quietest.value >= quiet[source]) {
            quietest.value = quiet[source];
            quietest.index = source;
        }
        visited[source] = true;
        List<Integer> adjacents = graph[source];
        if (adjacents == null) {
            return;
        }
        for (int adj : adjacents) {
            if (!visited[adj]) {
                dfs(graph, adj, visited, quiet, quietest);
            }
        }
    }

    private static List<Integer>[] buildGraph(int[][] richer, int size) {
        List<Integer>[] graph = new List[size];
        for (int[] rich : richer) {
            if (graph[rich[1]] == null) {
                List<Integer> newList = new ArrayList<>();
                newList.add(rich[0]);
                graph[rich[1]] = newList;
            } else {
                graph[rich[1]].add(rich[0]);
            }
        }
        return graph;
    }
}
