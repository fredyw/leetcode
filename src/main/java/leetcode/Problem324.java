package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/wiggle-sort-ii/
 */
public class Problem324 {
    public void wiggleSort(int[] nums) {
        // TODO:
    }

    public static void main(String[] args) {
        Problem324 prob = new Problem324();

        int[] nums = new int[]{1, 5, 1, 1, 6, 4};
        prob.wiggleSort(nums);
        System.out.println(Arrays.toString(nums)); // [1, 4, 1, 5, 1, 6]

        nums = new int[]{1, 3, 2, 2, 3, 1};
        prob.wiggleSort(nums);
        System.out.println(Arrays.toString(nums)); // [2, 3, 1, 3, 1, 2]
    }
}
