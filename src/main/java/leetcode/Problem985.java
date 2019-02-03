package leetcode;

/**
 * https://leetcode.com/problems/sum-of-even-numbers-after-queries/
 */
public class Problem985 {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sum = 0;
        for (int a : A) {
            if (a % 2 == 0) {
                sum += a;
            }
        }
        int[] answer = new int[A.length];
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0];
            int index = queries[i][1];
            if (A[index] % 2 == 0) {
                sum -= A[index];
            }
            A[index] += val;
            if (A[index] %2 == 0) {
                sum += A[index];
            }
            answer[i] = sum;
        }
        return answer;
    }
}
