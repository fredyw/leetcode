package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 */
public class Problem797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem797 prob = new Problem797();
        System.out.println(prob.allPathsSourceTarget(new int[][]{
            {1, 2}, {3}, {3}, {}
        })); // [[0,1,3],[0,2,3]]
    }
}
