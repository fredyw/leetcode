package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sum-of-even-numbers-after-queries/
 */
public class Problem985 {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] answer = new int[A.length];
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0];
            int index = queries[i][1];
            A[index] += val;
            int sum = 0;
            for (int a : A) {
                if (a % 2 == 0) {
                    sum += a;
                }
            }
            answer[i] = sum;
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem985 prob = new Problem985();
        System.out.println(Arrays.toString(prob.sumEvenAfterQueries(new int[]{1, 2, 3, 4}, new int[][]{
            {1, 0}, {-3, 1}, {-4, 0}, {2, 3}
        }))); // [8,6,2,4]
    }
}
