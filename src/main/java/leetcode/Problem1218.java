package leetcode;

/**
 * https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/
 */
public class Problem1218 {
    public int longestSubsequence(int[] arr, int difference) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1218 prob = new Problem1218();
        System.out.println(prob.longestSubsequence(new int[]{1,2,3,4}, 1)); // 4
        System.out.println(prob.longestSubsequence(new int[]{1,3,5,7}, 1)); // 1
        System.out.println(prob.longestSubsequence(new int[]{1,5,7,8,5,3,4,2,1}, 2)); // 4
    }
}
