package leetcode;

/**
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class Problem83 {
    public int removeDuplicates(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int size = 1;
        int j = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == A[j]) {
                continue;
            }
            j++;
            A[j] = A[i];
            size++;
        }
        return size;
    }
}
