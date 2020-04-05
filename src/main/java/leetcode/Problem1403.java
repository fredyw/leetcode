package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/
 */
public class Problem1403 {
    public List<Integer> minSubsequence(int[] nums) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1403 prob = new Problem1403();
        System.out.println(prob.minSubsequence(new int[]{4,3,10,9,8})); // [10,9]
        System.out.println(prob.minSubsequence(new int[]{4,4,7,6,7})); // [7,7,6]
        System.out.println(prob.minSubsequence(new int[]{6})); // [6]
    }
}
