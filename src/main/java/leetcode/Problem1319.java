package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-operations-to-make-network-connected/
 */
public class Problem1319 {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        UnionFind uf = new UnionFind();
        for (int i = 0; i < connections.length; i++) {
            uf.union(connections[i][0], connections[i][1]);
        }
        int answer = new HashSet<>(uf.map.values()).size() - 1; // number of connected computers
        // number of remaining computers
        for (int i = 0; i < n; i++) {
            if (!uf.map.containsKey(i)) {
               answer++;
            }
        }
        return answer;
    }

    private static class UnionFind {
        private final Map<Integer, Integer> map = new HashMap<>();

        public void union(int a, int b) {
            if (!map.containsKey(a)) {
                map.put(a, a);
            }
            if (!map.containsKey(b)) {
                map.put(b, b);
            }
            if (map.get(a).equals(map.get(b))) {
                return; // already connected
            }
            Integer value = map.get(a);
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                if (e.getValue().equals(value)) {
                    map.put(e.getKey(), map.get(b));
                }
            }
        }
    }

    public static void main(String[] args) {
        Problem1319 prob = new Problem1319();
        System.out.println(prob.makeConnected(4, new int[][]{{0,1},{0,2},{1,2}})); // 1
        System.out.println(prob.makeConnected(6, new int[][]{{0,1},{0,2},{0,3},{1,2},{1,3}})); // 2
        System.out.println(prob.makeConnected(6, new int[][]{{0,1},{0,2},{0,3},{1,2},{1,3},{4,5}})); // 1
        System.out.println(prob.makeConnected(6, new int[][]{{0,1},{0,2},{0,3},{1,2}})); // -1
        System.out.println(prob.makeConnected(5, new int[][]{{0,1},{0,2},{3,4},{2,3}})); // 0
    }
}
