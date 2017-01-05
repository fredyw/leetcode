package leetcode;

/**
 * https://leetcode.com/problems/ones-and-zeroes/
 */
public class Problem474 {
    public int findMaxForm(String[] strs, int m, int n) {
        ZeroOne[] array = new ZeroOne[strs.length];
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            int nZero = 0;
            int nOne = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '0') {
                    nZero++;
                } else {
                    nOne++;
                }
            }
            array[i] = new ZeroOne(nZero, nOne);
        }
        Integer[][][] memo = new Integer[m + 1][n + 1][strs.length];
        int max = 0;
        for (int i = 0; i < strs.length; i++) {
            max = Math.max(max, findMaxFrom(array, m, n, i, memo));
        }
        return max;
    }

    private static int findMaxFrom(ZeroOne[] array, int m, int n, int idx, Integer[][][] memo) {
        if (idx == array.length) {
            return 0;
        }
        if (m < 0 || n < 0) {
            return 0;
        }
        ZeroOne zeroOne = array[idx];
        if (zeroOne.nZero == m && zeroOne.nOne == n) {
            return 1;
        }
        if (memo[m][n][idx] != null) {
            return memo[m][n][idx];
        }
        int addOne = (m - zeroOne.nZero >= 0 && n - zeroOne.nOne >= 0) ? 1 : 0;
        int a = findMaxFrom(array, m - zeroOne.nZero, n - zeroOne.nOne, idx + 1, memo) + addOne;
        int b = findMaxFrom(array, m, n, idx + 1, memo);
        int max = Math.max(a, b);
        memo[m][n][idx] = max;
        return max;
    }

    private static class ZeroOne {
        private final int nZero;
        private final int nOne;

        public ZeroOne(int nZero, int nOne) {
            this.nZero = nZero;
            this.nOne = nOne;
        }
    }
}
