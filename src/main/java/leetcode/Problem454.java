package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/4sum-ii/
 */
public class Problem454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                long sum = A[i] + B[j];
                if (!map.containsKey(sum)) {
                    map.put(sum, 1);
                } else {
                    map.put(sum, map.get(sum) + 1);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                long sum = C[i] + D[j];
                if (map.containsKey(-sum)) {
                    result += map.get(-sum);
                }
            }
        }
        return result;
    }
}
