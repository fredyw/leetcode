package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/smallest-string-with-swaps/
 */
public class Problem1202 {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        Map<Integer, Set<Integer>> graph = buildGraph(pairs);
        boolean[] visited = new boolean[s.length()];
        char[] answer = s.toCharArray();
        for (List<Integer> pair : pairs) {
            if (visited[pair.get(0)]) {
                continue;
            }
            List<Character> chars = new ArrayList<>();
            List<Integer> indexes = new ArrayList<>();
            dfs(graph, visited, pair.get(0), s, chars, indexes);
            Collections.sort(chars);
            Collections.sort(indexes);
            for (int i = 0; i < indexes.size(); i++) {
                answer[indexes.get(i)] = chars.get(i);
            }
        }
        return new String(answer);
    }

    private static void dfs(Map<Integer, Set<Integer>> graph, boolean[] visited,
                            int index, String string, List<Character> chars,
                            List<Integer> indexes) {
        visited[index] = true;;
        chars.add(string.charAt(index));
        indexes.add(index);
        for (int adjacent : graph.getOrDefault(index, Collections.emptySet())) {
            if (!visited[adjacent]) {
                dfs(graph, visited, adjacent, string, chars, indexes);
            }
        }
    }

    private static Map<Integer, Set<Integer>> buildGraph(List<List<Integer>> pairs) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (List<Integer> pair : pairs) {
            if (!graph.containsKey(pair.get(0))) {
                graph.put(pair.get(0), new HashSet<>());
            }
            graph.get(pair.get(0)).add(pair.get(1));
            if (!graph.containsKey(pair.get(1))) {
                graph.put(pair.get(1), new HashSet<>());
            }
            graph.get(pair.get(1)).add(pair.get(0));
        }
        return graph;
    }
}
