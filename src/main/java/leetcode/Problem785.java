package leetcode;

/**
 * https://leetcode.com/problems/is-graph-bipartite/
 */
public class Problem785 {
    public boolean isBipartite(int[][] graph) {
        // TODO
        return false;
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
