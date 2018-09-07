package leetcode;

/**
 * https://leetcode.com/problems/monotonic-array/
 */
public class Problem896 {
    public boolean isMonotonic(int[] A) {
        int cmp = 0;
        boolean first = true;
        for (int j = 0, i = 1; i < A.length; i++, j++) {
            if (first) {
                cmp = Integer.compare(A[j], A[i]);
                first = false;
            } else {
                int c = Integer.compare(A[j], A[i]);
                if (cmp == 0) {
                    cmp = c;
                }
                if (c != cmp && c != 0) {
                    return false;
                }
            }

        }
        return true;
    }
}
