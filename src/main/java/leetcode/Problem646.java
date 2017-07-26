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
        return findLongestChain(pairs, 0);
    }

    private static int findLongestChain(int[][] pairs, int idx) {
        if (idx == pairs.length) {
            return 0;
        }
        int max = 0;
        int[] current = pairs[idx];
        for (int i = idx + 1; i < pairs.length; i++) {
            int[] next = pairs[i];
            int val = 1;
            if (current[1] < next[0]) {
                val++;
            }
            max = Math.max(max, findLongestChain(pairs, i + 1) + val);
        }
        return max;
    }

    public static void main(String[] args) {
        Problem646 prob = new Problem646();
//        System.out.println(prob.findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}})); // 2
//        System.out.println(prob.findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}})); // 3
//        System.out.println(prob.findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}})); // 2
//        System.out.println(prob.findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {7, 8}})); // 4
        System.out.println(prob.findLongestChain(new int[][]{{-1, 0}, {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {7, 8}})); // 5
    }
}
