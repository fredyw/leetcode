package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 */
public class Problem797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // TODO
        Queue<Integer> queue = new LinkedList<>();
        while (!queue.isEmpty()) {

        }
        return null;
    }

    public static void main(String[] args) {
        Problem797 prob = new Problem797();
        System.out.println(prob.allPathsSourceTarget(new int[][]{
            {1, 2}, {3}, {3}, {}
        })); // [[0,1,3],[0,2,3]]
    }
}
