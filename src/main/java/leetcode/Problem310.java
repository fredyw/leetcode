package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-height-trees/
 */
public class Problem310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        // TODO:
        return result;
    }

    public static void main(String[] args) {
        Problem310 prob = new Problem310();
        System.out.println(prob.findMinHeightTrees(4, new int[][]{
            {1, 0}, {1, 2}, {1, 3}
        })); // 1
        System.out.println(prob.findMinHeightTrees(6, new int[][]{
            {0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}
        })); // 3, 4
        System.out.println(prob.findMinHeightTrees(7, new int[][]{
            {0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}, {0, 6}
        })); // 3
    }
}
