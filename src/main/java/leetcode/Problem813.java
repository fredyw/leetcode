package leetcode;

/**
 * https://leetcode.com/problems/largest-sum-of-averages/
 */
public class Problem813 {
    public double largestSumOfAverages(int[] A, int K) {
        Double[][] memo = new Double[K + 1][A.length];
        return largestSumOfAverages(A, K, 0, memo);
    }

    private static double largestSumOfAverages(int[] a, int k, int idx, Double[][] memo) {
        if (idx == a.length) {
            return 0;
        }
        if (k == 0) {
            return -1;
        }
        if (memo[k][idx] != null) {
            return memo[k][idx];
        }
        int size = 1;
        double sum = 0;
        double max = 0;
        for (int i = idx; i < a.length; i++) {
            sum += a[i];
            double avg = sum / size;
            double sa = largestSumOfAverages(a, k - 1, i + 1, memo);
            if (sa != -1) {
                max = Math.max(max, sa + avg);
            }
            size++;
        }
        memo[k][idx] = max;
        return max;
    }
}
