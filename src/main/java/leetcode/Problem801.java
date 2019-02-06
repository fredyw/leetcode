package leetcode;

/**
 * https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/
 */
public class Problem801 {
    public int minSwap(int[] A, int[] B) {
        Integer[][] memo = new Integer[A.length][2]; // 0 = no-swap, 1 = swap
        return minSwap(A, B, 0, 0, memo);
    }

    private static int minSwap(int[] a, int[] b, int i, int swap, Integer[][] memo) {
        if (i == a.length) {
            return 0;
        }
        if (memo[i][swap] != null) {
            return memo[i][swap];
        }
        int min = Integer.MAX_VALUE;
        if (i == 0 || a[i] > a[i - 1] && b[i] > b[i - 1]) {
            min = Math.min(min, minSwap(a, b, i + 1, 0, memo));
        }
        if (i == 0 || a[i] > b[i - 1] && b[i] > a[i - 1]) {
            swap(a, b, i);
            min = Math.min(min, minSwap(a, b, i + 1, 1, memo) + 1);
            swap(a, b, i); // backtrack
        }
        memo[i][swap] = min;
        return min;
    }

    private static void swap(int[] a, int[] b, int i) {
        int tmp = a[i];
        a[i] = b[i];
        b[i] = tmp;
    }
}
