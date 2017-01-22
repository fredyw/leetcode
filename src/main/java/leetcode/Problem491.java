package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/increasing-subsequences/
 */
public class Problem491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem491 prob = new Problem491();
        System.out.println(prob.findSubsequences(new int[]{1, 1, 1})); // [[1, 1], [1, 1, 1]]
        System.out.println(prob.findSubsequences(new int[]{1, 2, 2})); // [[1, 2], [2, 2], [1, 2, 2]]
        System.out.println(prob.findSubsequences(new int[]{4, 6, 7, 7})); // [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
    }
}
