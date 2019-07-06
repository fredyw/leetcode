package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/create-maximum-number/
 */
public class Problem321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem321 prob = new Problem321();
        System.out.println(Arrays.toString(prob.maxNumber(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5))); // [9, 8, 6, 5, 3]
        System.out.println(Arrays.toString(prob.maxNumber(new int[]{6, 7}, new int[]{6, 0, 4}, 5))); // [6, 7, 6, 0, 4]
        System.out.println(Arrays.toString(prob.maxNumber(new int[]{3, 9}, new int[]{8, 9}, 3))); // [9, 8, 9]
    }
}
