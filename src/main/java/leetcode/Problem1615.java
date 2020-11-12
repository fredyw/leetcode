package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/maximal-network-rank/
 */
public class Problem1615 {
    public int maximalNetworkRank(int n, int[][] roads) {
        Set<String>[] graph = new Set[n];
        for (int[] road : roads) {
            if (graph[road[0]] == null) {
                graph[road[0]] = new HashSet<>();
            }
            String edge = edge(road[0], road[1]);
            graph[road[0]].add(edge);
            if (graph[road[1]] == null) {
                graph[road[1]] = new HashSet<>();
            }
            graph[road[1]].add(edge);
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<String> set1 = graph[i] != null ? graph[i] : new HashSet<>();
                Set<String> set2 = graph[j] != null ? graph[j] : new HashSet<>();
                Set<String> set = new HashSet<>();
                set.addAll(set1);
                set.addAll(set2);
                answer = Math.max(answer, set.size());
            }
        }
        return answer;
    }

    private static String edge(int a, int b) {
        return a < b ? a + "," + b : b + "," + a;
    }

    public static void main(String[] args) {
        Problem1615 prob = new Problem1615();
        System.out.println(prob.maximalNetworkRank(
            4, new int[][]{{0,1},{0,3},{1,2},{1,3}})); // 4
        System.out.println(prob.maximalNetworkRank(
            5, new int[][]{{0,1},{0,3},{1,2},{1,3},{2,3},{2,4}})); // 5
        System.out.println(prob.maximalNetworkRank(
            8, new int[][]{{0,1},{1,2},{2,3},{2,4},{5,6},{5,7}})); // 5
        System.out.println(prob.maximalNetworkRank(
            2, new int[][]{})); // 0
        System.out.println(prob.maximalNetworkRank(
            2, new int[][]{{1, 0}})); // 1
        System.out.println(prob.maximalNetworkRank(
            4, new int[][]{{1, 0}, {2, 3}})); // 2
        System.out.println(prob.maximalNetworkRank(
            3, new int[][]{{0, 2}, {0, 1}})); // 2
    }
}
