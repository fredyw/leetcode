package leetcode;

/**
 * https://leetcode.com/problems/k-concatenation-maximum-sum/
 */
public class Problem1191 {
    public int kConcatenationMaxSum(int[] arr, int k) {
        long answer = 0;
        long maxSoFar = 0;
        for (int j = 0; j < k; j++) {
            for (int i = 0; i < arr.length; i++) {
                maxSoFar = Math.max(arr[i], (maxSoFar + arr[i]) % 1_000_000_007) ;
                answer = Math.max(answer, maxSoFar);
            }
        }
        return (int) answer;
    }

    public static void main(String[] args) {
        Problem1191 prob = new Problem1191();
//        System.out.println(prob.kConcatenationMaxSum(new int[]{1,2}, 3)); // 9
//        System.out.println(prob.kConcatenationMaxSum(new int[]{1,-2,1}, 5)); // 2
        System.out.println(prob.kConcatenationMaxSum(new int[]{1,3-2,5,8}, 2)); // 30
//        System.out.println(prob.kConcatenationMaxSum(new int[]{-1,-2}, 7)); // 0
//        System.out.println(prob.kConcatenationMaxSum(new int[]{1,2,-3}, 3)); // 3
//        System.out.println(prob.kConcatenationMaxSum(new int[]{1,2,-3,4}, 3)); // 12
    }
}
