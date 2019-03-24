package leetcode;

/**
 * https://leetcode.com/problems/best-sightseeing-pair/
 */
public class Problem1021 {
    public int maxScoreSightseeingPair(int[] A) {
        int answer = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int val = A[i] + A[j] + i - j;
                answer = Math.max(answer, val);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem1021 prob = new Problem1021();
        System.out.println(prob.maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6})); // 11
    }
}
