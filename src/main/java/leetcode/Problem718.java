package leetcode;

/**
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/
 */
public class Problem718 {
    public int findLength(int[] A, int[] B) {
        int max = 0;
        Integer[][] memo = new Integer[A.length + 1][B.length + 1];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                max = Math.max(max, findLength(A, B, i, j, memo));
            }
        }
        return max;
//        int max = 0;
//        int[][] memo = new int[A.length + 1][B.length + 1];
//        for (int i = A.length - 1; i >= 0; i--) {
//            for (int j = B.length - 1; j >= 0; j--) {
//                if (A[i] == B[j]) {
//                    memo[i][j] = memo[i + 1][j + 1] + 1;
//                }
//                max = Math.max(max, memo[i][j]);
//            }
//        }
//        return max;
    }

    private static int findLength(int[] a, int[] b, int i, int j, Integer[][] memo) {
        if (i == a.length) {
            return 0;
        }
        if (j == b.length) {
            return 0;
        }
        int max = 0;
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (a[i] == b[j]) {
            max = Math.max(max, findLength(a, b, i + 1, j + 1, memo) + 1);
        }
        memo[i][j] = max;
        return max;
    }

    public static void main(String[] args) {
        Problem718 prob = new Problem718();
        System.out.println(prob.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7})); // 3
        System.out.println(prob.findLength(new int[]{1, 1, 2, 3, 2, 1}, new int[]{1, 1, 3, 2, 1, 4, 7})); // 3
        System.out.println(prob.findLength(new int[]{0, 1, 1, 1, 1}, new int[]{1, 0, 1, 0, 1})); // 2
        System.out.println(prob.findLength(new int[]{0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, new int[]{0, 0, 0, 0, 0, 0, 0, 1, 0, 0})); // 9
    }
}
