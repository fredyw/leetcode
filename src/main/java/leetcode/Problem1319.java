package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/number-of-operations-to-make-network-connected/
 */
public class Problem1319 {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < connections.length; i++) {
            uf.union(connections[i][0], connections[i][1]);
        }
        int answer = 0;
        Set<Integer> connected = new HashSet<>(); // number of connected computers
        for (int i = 0; i < uf.map.length; i++) {
            if (uf.map[i] == null) {
                answer++; // number of remaining computers
            } else {
                connected.add(uf.map[i]);
            }
        }
        return answer + connected.size() - 1;
    }

    private static class UnionFind {
        private final Integer[] map;

        public UnionFind(int n) {
            this.map = new Integer[n];
        }

        public void union(int a, int b) {
            if (map[a] == null) {
                map[a] = a;
            }
            if (map[b] == null) {
                map[b] = b;
            }
            if (map[a].equals(map[b])) {
                return; // already connected
            }
            Integer value = map[a];
            for (int i = 0; i < map.length; i++) {
                if (map[i] == null) {
                    continue;
                }
                if (map[i].equals(value)) {
                    map[i] = map[b];
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
