package leetcode;

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
        private final Integer[] map = new Integer[1001];

        public void union(int a, int b) {
            if (map[a] == null) {
                map[a] = a;
            }
            if (map[b] == null) {
                map[b] = b;
            }
            if (connected(a, b)) {
                return;
            }
            int value = map[a];
            for (int i = 0; i < map.length; i++) {
                if (map[i] != null) {
                    if (map[i] == value) {
                        map[i] = map[b];
                    }
                }
            }
        }

        public boolean connected(int a, int b) {
            if (map[a] == null || map[b] == null) {
                return false;
            }
            return map[a] == map[b];
        }
    }
}
