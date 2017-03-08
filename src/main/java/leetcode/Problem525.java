package leetcode;

/**
 * https://leetcode.com/problems/contiguous-array/
 */
public class Problem525 {
    public int findMaxLength(int[] nums) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem525 prob = new Problem525();
        System.out.println(prob.findMaxLength(new int[]{0, 1})); // 2
        System.out.println(prob.findMaxLength(new int[]{0, 1, 0})); // 2
        System.out.println(prob.findMaxLength(new int[]{0, 1, 1, 0, 1})); // 4
    }
}
