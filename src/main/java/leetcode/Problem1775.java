package leetcode;

/**
 * https://leetcode.com/problems/equal-sum-arrays-with-minimum-number-of-operations/
 */
public class Problem1775 {
    public int minOperations(int[] nums1, int[] nums2) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1775 prob = new Problem1775();
        System.out.println(prob.minOperations(new int[]{1,2,3,4,5,6}, new int[]{1,1,2,2,2,2})); // 3
        System.out.println(prob.minOperations(new int[]{1,1,1,1,1,1,1}, new int[]{6})); // -1
        System.out.println(prob.minOperations(new int[]{6,6}, new int[]{1})); // 3
    }
}
