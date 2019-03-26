package leetcode;

/**
 * https://leetcode.com/problems/best-sightseeing-pair/
 */
public class Problem1021 {
    public int maxScoreSightseeingPair(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] += i;
        }
        int answer = 0;
        int maxSoFar = 0;
        for (int i = 0; i < A.length; i++) {
            answer = Math.max(answer, A[i] + maxSoFar - (i * 2));
            maxSoFar = Math.max(maxSoFar, A[i]);
        }
        return answer;
    }
}
