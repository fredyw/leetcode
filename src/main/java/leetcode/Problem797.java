package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 */
public class Problem797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        allPaths(graph, 0, new ArrayList<>(), result);
        return result;
    }

    private static void allPaths(int[][] graph, int source, List<Integer> accu,
                                 List<List<Integer>> result) {
        accu.add(source);
        if (graph[source].length == 0) {
            result.add(accu);
        } else {
            for (int neighbor : graph[source]) {
                allPaths(graph, neighbor, new ArrayList<>(accu), result);
            }
        }
    }
}
