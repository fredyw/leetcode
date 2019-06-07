package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/distant-barcodes/
 */
public class Problem1054 {
    public int[] rearrangeBarcodes(int[] barcodes) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1054 prob = new Problem1054();
        System.out.println(Arrays.toString(prob.rearrangeBarcodes(new int[]{1, 1, 1, 2, 2, 2}))); // [2,1,2,1,2,1]
        System.out.println(Arrays.toString(prob.rearrangeBarcodes(new int[]{1, 1, 1, 1, 2, 2, 3, 3}))); // [1,3,1,3,2,1,2,1]
    }
}
