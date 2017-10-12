package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/redundant-connection/
 */
public class Problem684 {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind();
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            if (uf.connected(a, b)) {
                return edges[i];
            }
            uf.union(a, b);
        }
        throw new RuntimeException("Should not happen");
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
            if (connected(a, b)) {
                return;
            }
            int value = map.get(a);
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                if (e.getValue().equals(value)) {
                    map.put(e.getKey(), map.get(b));
                }
            }
        }

        public boolean connected(int a, int b) {
            if (!map.containsKey(a) || !map.containsKey(b)) {
                return false;
            }
            return map.get(a).equals(map.get(b));
        }
    }

    public static void main(String[] args) {
        Problem684 prob = new Problem684();
        System.out.println(Arrays.toString(prob.findRedundantConnection(new int[][]{
            {1, 2}, {1, 3}, {2, 3}
        }))); // [2,3]
        System.out.println(Arrays.toString(prob.findRedundantConnection(new int[][]{
            {1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}
        }))); // [1,4]
        System.out.println(Arrays.toString(prob.findRedundantConnection(new int[][]{
            {3, 4}, {2, 3}, {1, 2}, {1, 4}, {1, 5}
        }))); // [1,4]
        System.out.println(Arrays.toString(prob.findRedundantConnection(new int[][]{
            {3, 4}, {2, 3}, {1, 4}, {1, 2}, {1, 5}
        }))); // [1,2]
    }
}
