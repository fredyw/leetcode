package leetcode;

/**
 * https://leetcode.com/problems/rotate-function/
 */
public class Problem396 {
    public int maxRotateFunction(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        long max = Long.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            long tmpMax = 0;
            for (int j = 0, k = i; j < A.length; j++, k++) {
                if (k == A.length) {
                    k = 0;
                }
                tmpMax += A[k] * j;
            }
            max = Math.max(max, tmpMax);
        }
        return (int) max;
    }
}
