package leetcode;

/**
 * https://leetcode.com/problems/sort-array-by-parity-ii/
 */
public class Problem922 {
    public int[] sortArrayByParityII(int[] A) {
        int[] odd = new int[(A.length / 2) + 1];
        int[] even = new int[(A.length / 2) + 1];
        int oddIdx = 0;
        int evenIdx = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                even[evenIdx++] = A[i];
            } else {
                odd[oddIdx++] = A[i];
            }
        }
        oddIdx = 0;
        evenIdx = 0;
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0) {
                A[i] = even[evenIdx++];
            } else {
                A[i] = odd[oddIdx++];
            }
        }
        return A;
    }
}
