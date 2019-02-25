package leetcode;

/**
 * https://leetcode.com/problems/maximum-sum-circular-subarray/
 */
public class Problem918 {
    public int maxSubarraySumCircular(int[] A) {
        int answer = A[0];
        for (int i = 0; i < A.length; i++) {
            int sum = A[i];
            answer = Math.max(answer, sum);
            int j = (i + 1) % A.length;
            while (j != i) {
                sum += A[j];
                answer = Math.max(answer, sum);
                j = (j + 1) % A.length;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem918 prob = new Problem918();
        System.out.println(prob.maxSubarraySumCircular(new int[]{1, -2, 3, -2})); // 3
        System.out.println(prob.maxSubarraySumCircular(new int[]{5, -3, 5})); // 10
        System.out.println(prob.maxSubarraySumCircular(new int[]{3, -1, 2, -1})); // 4
        System.out.println(prob.maxSubarraySumCircular(new int[]{3, -2, 2, -3})); // 3
        System.out.println(prob.maxSubarraySumCircular(new int[]{-2, -3, -1})); // -1
    }
}
