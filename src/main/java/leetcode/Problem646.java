package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-length-of-pair-chain/
 */
public class Problem646 {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> {
            int cmp = Integer.compare(a[0], b[0]);
            if (cmp == 0) {
                return Integer.compare(a[1], b[1]);
            }
            return cmp;
        });
        Integer[] memo = new Integer[pairs.length];
        int max = 0;
        for (int i = 0; i < pairs.length; i++) {
            max = Math.max(max, findLongestChain(pairs, i, memo) + 1);
        }
        return max;
    }

    private static int findLongestChain(int[][] pairs, int idx, Integer[] memo) {
        if (idx == pairs.length) {
            return 0;
        }
        if (memo[idx] != null) {
            return memo[idx];
        }
        int max = 0;
        int[] current = pairs[idx];
        for (int i = idx + 1; i < pairs.length; i++) {
            int[] next = pairs[i];
            if (current[1] < next[0]) {
                max = Math.max(max, findLongestChain(pairs, i, memo) + 1);
            }
        }
        memo[idx] = max;
        return max;
    }
}
