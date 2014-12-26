package leetcode;

/**
 * https://oj.leetcode.com/problems/remove-element/
 */
public class Problem27 {
    public int removeElement(int[] A, int elem) {
        int idx = A.length - 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == elem) {
                while (idx >= i && A[idx] == elem) {
                    idx--;
                }
                if (idx < i) {
                    return idx + 1;
                }
                int tmp = A[i];
                A[i] = A[idx];
                A[idx] = tmp;
                idx--;
            }
            if (i == idx) {
                break;
            }
        }
        System.out.println(idx);
        return idx + 1;
    }
}
