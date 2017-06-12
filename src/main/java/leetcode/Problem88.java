package leetcode;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class Problem88 {
    public void merge(int A[], int m, int B[], int n) {
        int[] aux = new int[A.length];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = A[i];
        }
        int x = 0;
        int y = 0;
        int idx = 0;
        while (x < m && y < n) {
            if (A[x] <= B[y]) {
                aux[idx++] = A[x++];
            } else {
                aux[idx++] = B[y++];
            }
        }
        if (x < m) {
            for (int i = x; i < m; i++) {
                aux[idx++] = A[i];
            }
        }
        if (y < n) {
            for (int i = y; i < n; i++) {
                aux[idx++] = B[i];
            }
        }
        for (int i = 0; i < aux.length; i++) {
            A[i] = aux[i];
        }
    }
}
