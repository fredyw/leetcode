package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/duplicate-zeros/
 */
public class Problem1089 {
    public void duplicateZeros(int[] arr) {
        // TODO
    }

    public static void main(String[] args) {
        Problem1089 prob = new Problem1089();
        int[] a = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        prob.duplicateZeros(a);
        System.out.println(Arrays.toString(a));
        a = new int[]{1, 2, 3};
        prob.duplicateZeros(a);
        System.out.println(Arrays.toString(a));
    }
}
