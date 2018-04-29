package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-eventual-safe-states/
 */
public class Problem802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // TODO
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        Problem802 prob = new Problem802();
        System.out.println(prob.eventualSafeNodes(new int[][]{
            {1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}
        })); // [2,4,5,6]
        System.out.println(prob.eventualSafeNodes(new int[][]{
            {1,2},{1},{0}
        })); // []
    }
}
