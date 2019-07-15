package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/relative-sort-array/
 */
public class Problem1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1122 prob = new Problem1122();
        System.out.println(Arrays.toString(prob.relativeSortArray(
            new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19},
            new int[]{2, 1, 4, 3, 9, 6}))); // [2,2,2,1,4,3,3,9,6,7,19]
    }
}
