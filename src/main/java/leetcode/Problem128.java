package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class Problem128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int num : nums) {
            int a = num - 1;
            int b = num + 1;
            graph.putIfAbsent(num, new ArrayList<>());
            if (set.contains(a)) {
                graph.get(num).add(a);
            }
            if (set.contains(b)) {
                graph.get(num).add(b);
            }
        }
        Set<Integer> visited = new HashSet<>();
        int answer = 0;
        for (int num : nums) {
            if (!visited.contains(num)) {
                answer = Math.max(answer, dfs(graph, visited, num));
            }
        }
        return answer;
    }

    private static int dfs(Map<Integer, List<Integer>> graph, Set<Integer> visited, int num) {
        visited.add(num);
        int count = 0;
        for (int neighbor : graph.get(num)) {
            if (!visited.contains(neighbor)) {
                count += dfs(graph, visited, neighbor);
            }
        }
        return count + 1;
    }
}
