package leetcode;

/**
 * https://leetcode.com/problems/k-concatenation-maximum-sum/
 */
public class Problem1191 {
    public int kConcatenationMaxSum(int[] arr, int k) {
        long totalSum = 0;
        for (int a : arr) {
            totalSum += a;
        }
        int prefixSum = 0;
        int i = 0;
        while (i < arr.length && arr[i] >= 0) {
            prefixSum += arr[i++];
        }
        int suffixSum = 0;
        i = arr.length - 1;
        while (i >= 0 && arr[i] >= 0) {
            suffixSum += arr[i--];
        }
        // Kadane's algorithm.
        long max = 0;
        long maxSoFar = 0;
        for (i = 0; i < arr.length; i++) {
            maxSoFar = Math.max(arr[i], (maxSoFar + arr[i]));
            max = Math.max(max, maxSoFar);
        }
        long answer;
        if (totalSum > 0) {
            long max1 = max + (totalSum * (k - 1));
            long max2 = (prefixSum + suffixSum) + (totalSum * (k - 2));
            answer = Math.max(max1, max2);
        } else {
            long max1 = max;
            long max2 = prefixSum + suffixSum;
            answer = Math.max(max1, max2);
        }
        return (int) answer % 1_000_000_007;
    }

    public static void main(String[] args) {
        Problem1191 prob = new Problem1191();
//        System.out.println(prob.kConcatenationMaxSum(new int[]{1,2}, 3)); // 9
//        System.out.println(prob.kConcatenationMaxSum(new int[]{1,-2,1}, 5)); // 2
//        System.out.println(prob.kConcatenationMaxSum(new int[]{1,-2,4}, 2)); // 7
//        System.out.println(prob.kConcatenationMaxSum(new int[]{5,-10,6}, 4)); // 13
//        System.out.println(prob.kConcatenationMaxSum(new int[]{5,-10,4}, 3)); // 9
//        System.out.println(prob.kConcatenationMaxSum(new int[]{1,3-2,5,8}, 2)); // 30
//        System.out.println(prob.kConcatenationMaxSum(new int[]{1,3-2,5,8}, 3)); // 45
//        System.out.println(prob.kConcatenationMaxSum(new int[]{-1,-2}, 7)); // 0
//        System.out.println(prob.kConcatenationMaxSum(new int[]{1,2,-3}, 3)); // 3
//        System.out.println(prob.kConcatenationMaxSum(new int[]{1,2,-3,4}, 3)); // 12
//        System.out.println(prob.kConcatenationMaxSum(new int[]{-5,4,-4,-3,5,-3}, 3)); // 5
        System.out.println(prob.kConcatenationMaxSum(new int[]{-9,13,4,-16,-12,-16,3,-7,5,-16,16,8,-1,-13,15,3}, 6)); // 36
    }
}
