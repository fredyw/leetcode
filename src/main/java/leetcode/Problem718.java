package leetcode;

/**
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/
 */
public class Problem718 {
    public int findLength(int[] A, int[] B) {
        Integer[][] memo = new Integer[A.length + 1][B.length + 1];
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, findLength(A, B, i, 0, false, memo));
        }
        return max;
    }

    private static int findLength(int[] a, int[] b, int i, int j, boolean found, Integer[][] memo) {
        if (i == a.length) {
            return 0;
        }
        if (j == b.length) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        int max = 0;
        if (a[i] == b[j]) {
            max = Math.max(max, findLength(a, b, i + 1, j + 1, true, memo) + 1);
        } else {
            if (found) {
                return max;
            }
            max = Math.max(max, findLength(a, b, i, j + 1, false, memo));
        }
        memo[i][j] = max;
        return max;
    }

    public static void main(String[] args) {
        Problem718 prob = new Problem718();
        System.out.println(prob.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7})); // 3
        System.out.println(prob.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{1, 3, 2, 1, 4, 7})); // 3
        System.out.println(prob.findLength(new int[]{0, 1, 1, 1, 1}, new int[]{1, 0, 1, 0, 1})); // 2
        System.out.println(prob.findLength(new int[]{0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, new int[]{0, 0, 0, 0, 0, 0, 0, 1, 0, 0})); // 9
    }
}
