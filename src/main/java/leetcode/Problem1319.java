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

    public static void main(String[] args) {
        Problem1319 prob = new Problem1319();
        System.out.println(prob.makeConnected(4, new int[][]{{0,1},{0,2},{1,2}})); // 1
        System.out.println(prob.makeConnected(6, new int[][]{{0,1},{0,2},{0,3},{1,2},{1,3}})); // 2
        System.out.println(prob.makeConnected(6, new int[][]{{0,1},{0,2},{0,3},{1,2},{1,3},{4,5}})); // 1
        System.out.println(prob.makeConnected(6, new int[][]{{0,1},{0,2},{0,3},{1,2}})); // -1
        System.out.println(prob.makeConnected(5, new int[][]{{0,1},{0,2},{3,4},{2,3}})); // 0
    }
}
