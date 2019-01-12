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
            while (A[j] <= A[i]) {
                A[j]++;
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem945 prob = new Problem945();
        System.out.println(prob.minIncrementForUnique(new int[]{1, 2, 2})); // 1
        System.out.println(prob.minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7})); // 6
    }
}
