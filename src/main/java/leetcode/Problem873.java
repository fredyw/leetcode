package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/
 */
public class Problem873 {
    public int lenLongestFibSubseq(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], i);
        }
        int max = 0;
        Integer[][] memo = new Integer[A.length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int val = lenLongestFibSubseq(A, i, j, map, memo);
                if (val > 0) {
                    val += 2;
                }
                max = Math.max(max, val);
            }
        }
        return max;
    }

    private int lenLongestFibSubseq(int[] a, int i, int j, Map<Integer, Integer> map,
                                    Integer[][] memo) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        int sum = a[i] + a[j];
        int max = 0;
        Integer index = map.get(sum);
        if (index != null) {
            max = lenLongestFibSubseq(a, j, index, map, memo) + 1;
            memo[i][j] = max;
        }
        return max;
    }
}
