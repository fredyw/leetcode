package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/smallest-range-ii/
 */
public class Problem910 {
    public int smallestRangeII(int[] A, int K) {
        if (A.length == 1) {
            return 0;
        }
        Arrays.sort(A);
        int answer = A[A.length - 1] - A[0];
        for (int i = 0; i < A.length - 1; i++) {
            int hi = Math.max(A[A.length - 1] - K, A[i] + K);
            int lo = Math.min(A[0] + K, A[i + 1] - K);
            answer = Math.min(answer, hi - lo);
        }
        return answer;
    }
}
