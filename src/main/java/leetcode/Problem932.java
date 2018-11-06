package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/beautiful-array/
 */
public class Problem932 {
    public int[] beautifulArray(int N) {
        Map<Integer, int[]> memo = new HashMap<>();
        return beautifulArray(N, memo);
    }

    public int[] beautifulArray(int n, Map<Integer, int[]> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int[] result = new int[n];
        if (n == 1) {
            result[0] = 1;
        } else {
            int i = 0;
            for (int x : beautifulArray((n + 1) / 2)) {  // odds
                result[i++] = 2 * x - 1;
            }
            for (int x : beautifulArray(n / 2)) { // evens
                result[i++] = 2 * x;
            }
        }
        memo.put(n, result);
        return result;
    }
}
