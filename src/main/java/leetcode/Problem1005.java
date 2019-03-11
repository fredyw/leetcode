package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/
 */
public class Problem1005 {
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (K == 0) {
                break;
            }
            if (A[i] < 0) {
                A[i] = -A[i];
                K--;
            } else {
                break;
            }
        }
        Arrays.sort(A);
        if (K > 0) {
            if (K % 2 > 0) {
                A[0] = -A[0];
            }
        }
        int sum = 0;
        for (int a : A) {
            sum += a;
        }
        return sum;
    }
}
