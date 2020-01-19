package leetcode;

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
        return uf.count - 1;
    }

    private static class UnionFind {
        private int[] parent; // parent[i] = parent of i
        private int count;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        private int root(int i) {
            while (i != parent[i]) {
                i = parent[i];
            }
            return i;
        }

        private void union(int a, int b) {
            int rootA = root(a);
            int rootB = root(b);
            if (rootA == rootB) {
                return;
            }
            parent[rootA] = rootB;
            count--;
        }
    }
}
