package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 */
public class Problem977 {
    public int[] sortedSquares(int[] A) {
        int[] answer = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            answer[i] = A[i] * A[i];
        }
        Arrays.sort(answer);
        return answer;
    }
}
