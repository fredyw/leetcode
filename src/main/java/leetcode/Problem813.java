package leetcode;

/**
 * https://leetcode.com/problems/largest-sum-of-averages/
 */
public class Problem813 {
    public double largestSumOfAverages(int[] A, int K) {
        return largestSumOfAverages(A, K, 0);
    }

    private static double largestSumOfAverages(int[] a, int k, int idx) {
        if (idx == a.length || k == 0) {
            return 0;
        }
        int size = 1;
        double max = 0;
        for (int i = idx; i < a.length; i++) {
            double avg = (a[i] / size);
            max = Math.max(max, largestSumOfAverages(a, k - 1, i + 1) + avg);
            size++;
        }
        return max;
    }

    public static void main(String[] args) {
        Problem813 prob = new Problem813();
        System.out.println(prob.largestSumOfAverages(new int[]{9, 1, 2, 3, 9}, 3)); // 20
//        System.out.println(prob.largestSumOfAverages(new int[]{1, 2, 3, 4, 5, 6, 7}, 4)); // 20.5
    }
}
