package leetcode;

/**
 * https://leetcode.com/problems/is-graph-bipartite/
 */
public class Problem785 {
    public boolean isBipartite(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        boolean[] map = new boolean[graph.length];
        Bipartite bipartite = new Bipartite();
        for (int vertex = 0; vertex < graph.length; vertex++) {
            if (!visited[vertex]) {
                isBipartite(graph, vertex, visited, map, bipartite);
            }
        }
        return bipartite.isBipartite;
    }

    private static class Bipartite {
        private boolean isBipartite = true;
    }

    private static void isBipartite(int[][] graph, int source,
                                    boolean[] visited, boolean[] map,
                                    Bipartite bipartite) {
        visited[source] = true;
        for (int adj : graph[source]) {
            if (!visited[adj]) {
                map[adj] = !map[source];
                isBipartite(graph, adj, visited, map, bipartite);
            } else {
                if (map[source] == map[adj]) {
                    bipartite.isBipartite = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Problem785 prob = new Problem785();
        System.out.println(prob.isBipartite(new int[][]{
            {1, 3}, {0, 2}, {1, 3}, {0, 2}
        })); // true
        System.out.println(prob.isBipartite(new int[][]{
            {1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}
        })); // false
    }
}
