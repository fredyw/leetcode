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
        if (idx == a.length || k == 0) {
            return 0;
        }
        if (memo[k][idx] != null) {
            return memo[k][idx];
        }
        int size = 1;
        double sum = 0;
        double max = 0;
        for (int i = idx; i < a.length; i++) {
            sum += a[i];
            double avg = (sum / size);
            max = Math.max(max, largestSumOfAverages(a, k - 1, i + 1, memo) + avg);
            size++;
        }
        memo[k][idx] = max;
        return max;
    }

    public static void main(String[] args) {
        Problem813 prob = new Problem813();
        System.out.println(prob.largestSumOfAverages(new int[]{9, 1, 2, 3, 9}, 3)); // 20
        System.out.println(prob.largestSumOfAverages(new int[]{1, 2, 3, 4, 5, 6, 7}, 4)); // 20.5
        System.out.println(prob.largestSumOfAverages(new int[]{4, 1, 7, 5, 6, 2, 3}, 4)); // 18.16667
    }
}
