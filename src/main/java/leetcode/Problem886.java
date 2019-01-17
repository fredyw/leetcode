package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/possible-bipartition/
 */
public class Problem886 {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        List<Integer>[] graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        boolean[] visited = new boolean[N + 1];
        for (int[] dislike : dislikes) {
            graph[dislike[0]].add(dislike[1]);
            graph[dislike[1]].add(dislike[0]);
        }
        boolean answer = true;
        // true -> black
        // false -> red
        boolean[] blackRed = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                answer &= isBipartite(graph, visited, blackRed, i);
            }
        }
        return answer;
    }

    private static boolean isBipartite(List<Integer>[] graph, boolean[] visited, boolean[] blackRed, int n) {
        visited[n] = true;
        boolean result = true;
        for (int adj : graph[n]) {
            if (!visited[adj]) {
                blackRed[adj] = !blackRed[n];
                result &= isBipartite(graph, visited, blackRed, adj);
            } else {
                if (blackRed[n] == blackRed[adj]) {
                    return false;
                }
            }
        }
        return result;
    }
}
