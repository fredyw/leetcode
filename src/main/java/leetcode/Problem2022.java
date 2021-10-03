package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/convert-1d-array-into-2d-array/
 */
public class Problem2022 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        // TODO
        return null;
    }

    private static void print(int[][] a) {
        for (int[] i : a) {
            System.out.println(Arrays.toString(i));
        }
    }

    public static void main(String[] args) {
        Problem2022 prob = new Problem2022();
        print(prob.construct2DArray(new int[]{1,2,3,4}, 2, 2)); // [[1,2],[3,4]]
        print(prob.construct2DArray(new int[]{1,2,3}, 1, 3)); // [[1,2,3]]
        print(prob.construct2DArray(new int[]{1,2}, 1, 1)); // []
        print(prob.construct2DArray(new int[]{3}, 1, 2)); // []

    }
}
