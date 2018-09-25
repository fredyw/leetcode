package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/smallest-range-i/description/
 */
public class Problem908 {
    public int smallestRangeI(int[] A, int K) {
        Arrays.sort(A);
        if (A.length <= 1) {
            return 0;
        }
        int diff = (A[A.length - 1] - K) - (A[0] + K);
        return diff < 0 ? 0 : diff;
    }
}
