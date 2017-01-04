package leetcode;

import java.util.HashMap;
import java.util.Map;

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
        int max = 0;
        Map<String, Integer> memo = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            max = Math.max(max, findMaxFrom(array, m, n, i, memo));
        }
        return max;
    }

    private static int findMaxFrom(ZeroOne[] array, int m, int n, int idx, Map<String, Integer> memo) {
        if (idx == array.length) {
            return 0;
        }
        String key = idx + "|" + m + "|" + n;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        ZeroOne zeroOne = array[idx];
        if (zeroOne.nZero == m && zeroOne.nOne == n) {
            return 1;
        }
        int max = 0;
        if (zeroOne.nZero <= m & zeroOne.nOne <= n) {
            max = findMaxFrom(array, m - zeroOne.nZero, n - zeroOne.nOne, idx + 1, memo) + 1;
        } else {
            max = findMaxFrom(array, m, n, idx + 1, memo);
        }
        memo.put(key, max);
        return max;
    }

    private static class ZeroOne {
        private final int nZero;
        private final int nOne;

        public ZeroOne(int nZero, int nOne) {
            this.nZero = nZero;
            this.nOne = nOne;
        }

        @Override
        public String toString() {
            return "(0 -> " + nZero + ", 1 -> " + nOne + ")";
        }
    }

    public static void main(String[] args) {
        Problem474 prob = new Problem474();
        System.out.println(prob.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3)); // 4
        System.out.println(prob.findMaxForm(new String[]{"10", "0", "1"}, 1, 1)); // 2
        System.out.println(prob.findMaxForm(new String[]{"10", "0", "1"}, 3, 1)); // 2
        System.out.println(prob.findMaxForm(new String[]{"10","0001","111001","1","0"}, 3, 4)); // 3
        System.out.println(prob.findMaxForm(new String[]{"111","1000","1000","1000"}, 9, 3)); // 3
        System.out.println(prob.findMaxForm(new String[]{"0", "11", "1000", "01", "0", "101", "1", "1", "1", "0", "0", "0", "0", "1", "0", "0110101", "0", "11", "01", "00", "01111", "0011", "1", "1000", "0", "11101", "1", "0", "10", "0111"}, 9, 80)); // 17
    }
}
