package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        return maxEnvelops(envelopes, 0, new HashMap<>());
    }

    private static int maxEnvelops(int[][] envelops, int idx, Map<String, Integer> memo) {
        if (idx >= envelops.length) {
            return 0;
        }
        int max = 0;
        for (int i = idx + 1; i < envelops.length; i++) {
            if (envelops[idx][0] < envelops[i][0] && envelops[idx][0] < envelops[i][0]) {
                max = Math.max(max, maxEnvelops(envelops, i, memo)) + 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Problem354 prob = new Problem354();
//        System.out.println(prob.maxEnvelopes(new int[][]{
//            {2, 3},
//            {6, 4},
//            {6, 7}
//        })); // 2
//        System.out.println(prob.maxEnvelopes(new int[][]{
//            {5, 4},
//            {6, 4},
//            {6, 7},
//            {2, 3}
//        })); // 3
        System.out.println(prob.maxEnvelopes(new int[][]{
            {2, 3},
            {5, 10},
            {6, 4},
            {7, 8}
        })); // 3
//        System.out.println(prob.maxEnvelopes(new int[][]{
//            {2, 3},
//            {5, 10},
//            {6, 4},
//            {7, 8}
//        })); // 3
//        System.out.println(prob.maxEnvelopes(new int[][]{
//            {2, 3},
//            {3, 10},
//            {4, 4},
//            {5, 6},
//            {9, 9}
//        })); // 4
//        System.out.println(prob.maxEnvelopes(new int[][]{
//        })); // 0
//        System.out.println(prob.maxEnvelopes(new int[][]{
//            {2, 3},
//            {4, 5},
//            {6, 7}
//        })); // 3
    }
}
