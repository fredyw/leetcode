package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/russian-doll-envelopes/
 */
public class Problem354 {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, (a, b) -> {
            int cmp = Integer.compare(a[0], b[0]);
            if (cmp == 0) {
                return Integer.compare(a[1], b[1]);
            }
            return cmp;
        });
        int max = 0;
        int[] memo = new int[envelopes.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }
        for (int i = 0; i < envelopes.length; i++) {
            max = Math.max(max, maxEnvelops(envelopes, i, memo) + 1);
        }
        return max;
    }

    private static int maxEnvelops(int[][] envelops, int idx, int[] memo) {
        if (idx >= envelops.length) {
            return 0;
        }

        int max = 0;
        if (memo[idx] != -1) {
            return memo[idx];
        }
        for (int i = idx + 1; i < envelops.length; i++) {
            if (envelops[idx][0] < envelops[i][0] && envelops[idx][1] < envelops[i][1]) {
                max = Math.max(max, maxEnvelops(envelops, i, memo) + 1);
            }
        }
        memo[idx] = max;
        return max;
    }
}
