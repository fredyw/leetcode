package leetcode;

/**
 * https://leetcode.com/problems/contiguous-array/
 */
public class Problem525 {
    public int findMaxLength(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int zero = 0;
            int one = 0;
            for (int j = i; j < nums.length; j ++) {
                if (nums[j] == 0) {
                    zero++;
                } else {
                    one++;
                }
                if (zero == one) {
                    max = Math.max(max, zero + one);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Problem525 prob = new Problem525();
        System.out.println(prob.findMaxLength(new int[]{0, 1})); // 2
        System.out.println(prob.findMaxLength(new int[]{0, 1, 0})); // 2
        System.out.println(prob.findMaxLength(new int[]{0, 1, 1, 0, 1})); // 4
        System.out.println(prob.findMaxLength(new int[]{1, 1, 1, 0, 0})); // 4
        System.out.println(prob.findMaxLength(new int[]{1, 1, 1, 1, 1})); // 0
        System.out.println(prob.findMaxLength(new int[]{1, 1, 0, 0, 0, 0, 1})); // 4
    }
}
