package leetcode;

/**
 * https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/
 */
public class Problem795 {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int result = 0;
        int count = 0;
        int prevCount = 0;
        boolean found = false;
        for (int i = 0; i < A.length; i++) {
            if (L <= A[i] && A[i] <= R) {
                found = true;
                count++;
                prevCount = count;
                result += count;
            } else if (A[i] > R) {
                found = false;
                count = 0;
            } else {
                count++;
                if (found) {
                    result += prevCount;
                }
            }
        }
        return result;
    }
}
