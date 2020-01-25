package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-the-matrix-diagonally/
 */
public class Problem1329 {
    public int[][] diagonalSort(int[][] mat) {
        // TODO
        return null;
    }

    private static void print(int[][] mat) {
        for (int[] m : mat) {
            System.out.println(Arrays.toString(m));
        }
    }

    public static void main(String[] args) {
        Problem1329 prob = new Problem1329();
        // [[1,1,1,1],
        //  [1,2,2,2],
        //  [1,2,3,3]]
        print(prob.diagonalSort(new int[][]{
            {3, 3, 1, 1},
            {2, 2, 1, 2},
            {1, 1, 1, 2}
        }));
    }
}
