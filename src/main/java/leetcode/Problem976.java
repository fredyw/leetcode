package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/largest-perimeter-triangle/
 */
public class Problem976 {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 3; i >= 0; i--) {
            // a + b > c
            if (A[i] + A[i + 1] > A[i + 2]) {
                return A[i] + A[i + 1] + A[i + 2];
            }
        }
        return 0;
    }
}
