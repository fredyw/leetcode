package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/diagonal-traverse/
 */
public class Problem498 {
    public int[] findDiagonalOrder(int[][] matrix) {
        // TODO
        return new int[0];
    }

    public static void main(String[] args) {
        Problem498 prob = new Problem498();
        System.out.println(Arrays.toString(prob.findDiagonalOrder(new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        }))); // [1,2,4,7,5,3,6,8,9]
    }
}
