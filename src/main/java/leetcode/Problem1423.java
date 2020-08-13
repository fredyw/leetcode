package leetcode;

/**
 * https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 */
public class Problem1423 {
    public int maxScore(int[] cardPoints, int k) {
        int[] prefixSum = new int[cardPoints.length];
        for (int i = 0; i < cardPoints.length; i++) {
            if (i == 0) {
                prefixSum[i] = cardPoints[i];
            } else {
                prefixSum[i] = prefixSum[i - 1] + cardPoints[i];
            }
        }
        int answer = 0;
        for (int i = k - 1; i >= 0; i--) {
            if (i - k + 1 == 0) {
                answer = Math.max(answer, prefixSum[i]);
            } else {
                int sum = prefixSum[i] + getSuffixSum(prefixSum, cardPoints.length + i - k + 1);
                answer = Math.max(answer, sum);
            }
        }
        return Math.max(answer, getSuffixSum(prefixSum, cardPoints.length - k));
    }

    private static int getSuffixSum(int[] prefixSum, int index) {
        return prefixSum[prefixSum.length - 1] - (index - 1 < 0 ? 0 : prefixSum[index - 1]);
    }
}
