package leetcode;

/**
 * https://leetcode.com/problems/global-and-local-inversions/
 */
public class Problem775 {
    public boolean isIdealPermutation(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (Math.abs(A[i] - i) > 1) {
                return false;
            }
        }
        return true;
    }
}
