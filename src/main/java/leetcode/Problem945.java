package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-increment-to-make-array-unique/
 */
public class Problem945 {
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int answer = 0;
        for (int i = 0, j = 1; j < A.length; i++, j++) {
            if (A[j] <= A[i]) {
                int count = A[i] - A[j] + 1;
                A[j] += count;
                answer += count;
            }
        }
        return answer;
    }
}
