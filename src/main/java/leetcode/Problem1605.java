package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/
 */
public class Problem1605 {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1605 prob = new Problem1605();
        // [[3,0],
        //  [1,7]]
        System.out.println(Arrays.toString(
            prob.restoreMatrix(new int[]{3,8}, new int[]{4,7})
        ));
        // [[0,5,0],
        //  [6,1,0],
        //  [2,0,8]]
        System.out.println(Arrays.toString(
            prob.restoreMatrix(new int[]{5,7,10}, new int[]{8,6,8})
        ));
        // [[0,9,5],
        //  [6,0,3]]
        System.out.println(Arrays.toString(
            prob.restoreMatrix(new int[]{14,9}, new int[]{6,9,8})
        ));
        // [[1],
        //  [0]]
        System.out.println(Arrays.toString(
            prob.restoreMatrix(new int[]{1,0}, new int[]{1})
        ));
        // [[0]]
        System.out.println(Arrays.toString(
            prob.restoreMatrix(new int[]{0}, new int[]{0})
        ));
    }
}
