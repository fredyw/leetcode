package leetcode;

/**
 * https://leetcode.com/problems/k-concatenation-maximum-sum/
 */
public class Problem1191 {
    public int kConcatenationMaxSum(int[] arr, int k) {
        long totalSum = 0;
        int prefixSum = 0;
        for (int a : arr) {
            totalSum += a;
        }
        // Kadene's algorithm.
        long max = 0;
        long maxSoFar = 0;
        for (int i = 0; i < arr.length; i++) {
            maxSoFar = Math.max(arr[i], (maxSoFar + arr[i]));
            max = Math.max(max, maxSoFar);
        }
        long answer = max;
        if (totalSum > 0) {
            answer += totalSum * (k - 1);
        } else {
            answer += prefixSum;
        }
        return (int) answer % 1_000_000_007;
    }

    public static void main(String[] args) {
        Problem1191 prob = new Problem1191();
//        System.out.println(prob.kConcatenationMaxSum(new int[]{1,2}, 3)); // 9
//        System.out.println(prob.kConcatenationMaxSum(new int[]{1,-2,1}, 5)); // 2
//        System.out.println(prob.kConcatenationMaxSum(new int[]{1,-2,4}, 2)); // 7
//        System.out.println(prob.kConcatenationMaxSum(new int[]{5,-10,6}, 4)); // 13
        System.out.println(prob.kConcatenationMaxSum(new int[]{5,-10,4}, 3)); // 9
//        System.out.println(prob.kConcatenationMaxSum(new int[]{1,3-2,5,8}, 2)); // 30
//        System.out.println(prob.kConcatenationMaxSum(new int[]{1,3-2,5,8}, 3)); // 45
//        System.out.println(prob.kConcatenationMaxSum(new int[]{-1,-2}, 7)); // 0
//        System.out.println(prob.kConcatenationMaxSum(new int[]{1,2,-3}, 3)); // 3
//        System.out.println(prob.kConcatenationMaxSum(new int[]{1,2,-3,4}, 3)); // 12
    }
}
