package leetcode;

/**
 * https://leetcode.com/problems/minimum-score-triangulation-of-polygon/
 */
public class Problem1039 {
    public int minScoreTriangulation(int[] A) {
        Integer[][] memo = new Integer[A.length][A.length];
        return minScoreTriangulation(A, 0, A.length - 1, memo);
    }

    private static int minScoreTriangulation(int[] array, int i, int j, Integer[][] memo) {
        if (j - i + 1 < 3) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            int val = (minScoreTriangulation(array, i, k, memo) +
                minScoreTriangulation(array, k, j, memo)) +
                (array[i] * array[j] * array[k]);
            min = Math.min(min, val);
        }
        memo[i][j] = min;
        return min;
    }
}
