package leetcode;

/**
 * https://leetcode.com/problems/maximum-sum-circular-subarray/
 */
public class Problem918 {
    public int maxSubarraySumCircular(int[] A) {
        int total = 0;
        int maxSum = -30000;
        int maxSoFar = 0;
        int minSum = 30000;
        int minSoFar = 0;
        for (int a : A) {
            maxSoFar = Math.max(maxSoFar + a, a);
            maxSum = Math.max(maxSum, maxSoFar);
            minSoFar = Math.min(minSoFar + a, a);
            minSum = Math.min(minSum, minSoFar);
            total += a;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
}
