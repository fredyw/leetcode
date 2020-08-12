package leetcode;

/**
 * https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 */
public class Problem1423 {
    public int maxScore(int[] cardPoints, int k) {
        return maxScore(cardPoints, k, 0, cardPoints.length - 1,
            new Integer[cardPoints.length][cardPoints.length]);
    }

    private static int maxScore(int[] cardPoints, int k, int i, int j, Integer[][] memo) {
        if (k == 0) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        int a = maxScore(cardPoints, k - 1, i + 1, j, memo) + cardPoints[i];
        int b = maxScore(cardPoints, k - 1, i, j - 1, memo) + cardPoints[j];
        int max = Math.max(a, b);
        memo[i][j] = max;
        return max;
    }

    public static void main(String[] args) {
        Problem1423 prob = new Problem1423();
        System.out.println(prob.maxScore(new int[]{1,2,3,4,5,6,1}, 3)); // 12
        System.out.println(prob.maxScore(new int[]{2,2,2}, 2)); // 4
        System.out.println(prob.maxScore(new int[]{9,7,7,9,7,7,9}, 7)); // 55
        System.out.println(prob.maxScore(new int[]{1,1000,1}, 1)); // 1
        System.out.println(prob.maxScore(new int[]{1,79,80,1,1,1,200,1}, 3)); // 202
        System.out.println(prob.maxScore(new int[]{1,79,80,1,1,1,200,1}, 4)); // 281
    }
}
