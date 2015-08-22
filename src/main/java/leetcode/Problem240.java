package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 */
public class Problem240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] a : matrix) {
            if (Arrays.binarySearch(a, target) >= 0) {
                return true;
            }
        }
        return false;
    }
}
