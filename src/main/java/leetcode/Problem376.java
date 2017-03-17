package leetcode;

/**
 * https://leetcode.com/problems/wiggle-subsequence/
 */
public class Problem376 {
    public int wiggleMaxLength(int[] nums) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem376 prob = new Problem376();
        System.out.println(prob.wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5})); // 6
        System.out.println(prob.wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8})); // 7
        System.out.println(prob.wiggleMaxLength(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})); // 2
    }
}
