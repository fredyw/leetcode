package leetcode;

/**
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/
 */
public class Problem718 {
    public int findLength(int[] A, int[] B) {
        int max = 0;
        int[][] memo = new int[A.length + 1][B.length + 1];
        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = B.length - 1; j >= 0; j--) {
                if (A[i] == B[j]) {
                    memo[i][j] = memo[i + 1][j + 1] + 1;
                }
                max = Math.max(max, memo[i][j]);
            }
        }
        return max;
    }

//    public int findLength(int[] A, int[] B) {
//        int max = 0;
//        Integer[][] memo = new Integer[A.length + 1][B.length + 1];
//        for (int i = 0; i < A.length; i++) {
//            for (int j = 0; j < B.length; j++) {
//                max = Math.max(max, findLength(A, B, i, j, memo));
//            }
//        }
//        return max;
//    }
//
//    private static int findLength(int[] a, int[] b, int i, int j, Integer[][] memo) {
//        if (i == a.length) {
//            return 0;
//        }
//        if (j == b.length) {
//            return 0;
//        }
//        int max = 0;
//        if (memo[i][j] != null) {
//            return memo[i][j];
//        }
//        if (a[i] == b[j]) {
//            max = Math.max(max, findLength(a, b, i + 1, j + 1, memo) + 1);
//        }
//        memo[i][j] = max;
//        return max;
//    }
}
