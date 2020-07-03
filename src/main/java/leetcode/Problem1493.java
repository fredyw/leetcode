package leetcode;

/**
 * https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
 */
public class Problem1493 {
    public int longestSubarray(int[] nums) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1493 prob = new Problem1493();
        System.out.println(prob.longestSubarray(new int[]{1,1,0,1})); // 3
        System.out.println(prob.longestSubarray(new int[]{0,1,1,1,0,1,1,0,1})); // 5
        System.out.println(prob.longestSubarray(new int[]{1,1,1})); // 2
        System.out.println(prob.longestSubarray(new int[]{1,1,0,0,1,1,1,0,1})); // 4
        System.out.println(prob.longestSubarray(new int[]{0,0,0})); // 0
    }
}
