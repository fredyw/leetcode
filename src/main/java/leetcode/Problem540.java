package leetcode;

/**
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 */
public class Problem540 {
    public int singleNonDuplicate(int[] nums) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem540 prob = new Problem540();
        System.out.println(prob.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8})); // 2
        System.out.println(prob.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11})); // 10
    }
}
