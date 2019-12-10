package leetcode;

/**
 * https://leetcode.com/problems/k-concatenation-maximum-sum/
 */
public class Problem1191 {
    public int kConcatenationMaxSum(int[] arr, int k) {
        int answer = 0;
        int maxSoFar = 0;
        for (int i = 0; i < arr.length; i++) {
            maxSoFar = Math.max(maxSoFar, maxSoFar + arr[i]);
            answer = Math.max(answer, maxSoFar);
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem1191 prob = new Problem1191();
        System.out.println(prob.kConcatenationMaxSum(new int[]{1,2}, 3)); // 9
        System.out.println(prob.kConcatenationMaxSum(new int[]{1,-2,1}, 5)); // 2
        System.out.println(prob.kConcatenationMaxSum(new int[]{-1,-2}, 7)); // 0
        System.out.println(prob.kConcatenationMaxSum(new int[]{1,2,-3}, 3)); // 3
        System.out.println(prob.kConcatenationMaxSum(new int[]{1,2,-3,4}, 3)); // 12
    }
}
