package leetcode;

/**
 * https://leetcode.com/problems/sum-of-subarray-minimums/
 */
public class Problem907 {
    public int sumSubarrayMins(int[] A) {
        long answer = 0;
        for (int i = 0; i < A.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < A.length; j++) {
                min = Math.min(min, A[j]);
                answer += min;
                answer %= 1000_000_007;
            }
        }
        return (int) answer % 1000_000_007;
    }

    public static void main(String[] args) {
        Problem907 prob = new Problem907();
        System.out.println(prob.sumSubarrayMins(new int[]{3, 1, 2, 4})); // 17
        System.out.println(prob.sumSubarrayMins(new int[]{3, 1, 2, 4, 10, 23})); // 76
    }
}
