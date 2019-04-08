package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/video-stitching/
 */
public class Problem1024 {
    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, (a, b) -> {
            int cmp = a[0] - b[0];
            if (cmp == 0) {
                return b[1] - a[1];
            }
            return cmp;
        });
        if (clips[0][0] != 0) {
            return -1;
        }
        Integer[] memo = new Integer[clips.length];
        int n = videoStitching(clips, T, 0, memo);
        return n == Integer.MAX_VALUE ? -1 : n + 1;
    }

    private static int videoStitching(int[][] clips, int t, int idx, Integer[] memo) {
        if (idx == clips.length || clips[idx][1] >= t) {
            return 0;
        }
        if (memo[idx] != null) {
            return memo[idx];
        }
        int min = Integer.MAX_VALUE;
        for (int i = idx + 1; i < clips.length; i++) {
            if (clips[idx][0] <= clips[i][0] && clips[i][0] <= clips[idx][1]) {
                int n = videoStitching(clips, t, i, memo);
                if (n != Integer.MAX_VALUE) {
                    min = Math.min(min, n + 1);
                }
            }
        }
        memo[idx] = min;
        return min;
    }
}
