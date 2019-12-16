package leetcode;

/**
 * https://leetcode.com/problems/k-concatenation-maximum-sum/
 */
public class Problem1191 {
    public int kConcatenationMaxSum(int[] arr, int k) {
        int mod = 1_000_000_007;
        long totalSum = 0;
        for (int a : arr) {
            totalSum += a;
        }
        long prefixSum = Integer.MIN_VALUE;
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            prefixSum = Math.max(prefixSum, sum) % mod;
        }
        long suffixSum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            sum += arr[i];
            suffixSum = Math.max(suffixSum, sum) % mod;
        }
        // Kadane's algorithm.
        long kadane = 0;
        long maxSoFar = 0;
        for (int i = 0; i < arr.length; i++) {
            maxSoFar = Math.max(arr[i], (maxSoFar + arr[i]));
            kadane = Math.max(kadane, maxSoFar) % mod;
        }
        if (totalSum > 0) {
            return (int) (Math.max(((totalSum * (k - 2)) % mod + suffixSum + prefixSum) % mod, kadane));
        }
        return (int) (Math.max((prefixSum + suffixSum) % mod, kadane));
    }
}
