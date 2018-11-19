package leetcode;

/**
 * https://leetcode.com/problems/valid-mountain-array/
 */
public class Problem941 {
    public boolean validMountainArray(int[] A) {
        if (A.length <= 2) {
            return false;
        }
        boolean increasing = true;
        boolean decreasing = false;
        for (int i = 0, j = 1; j < A.length; i++, j++) {
            if ((increasing && A[i] >= A[j]) ||
                (decreasing && A[i] <= A[j])) {
                return false;
            }
            if (A[i] < A[j]) {
                if (j + 1 < A.length && A[j] > A[j + 1]) {
                    increasing = false;
                    decreasing = true;
                }
            }
        }
        return !increasing && decreasing;
    }
}
