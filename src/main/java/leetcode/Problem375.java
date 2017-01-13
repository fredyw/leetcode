package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower-ii/
 */
public class Problem375 {
    public int getMoneyAmount(int n) {
        return getMoneyAmount(n, 1, n, new HashMap<>());
    }

    private static int getMoneyAmount(int n, int start, int end, Map<String, Integer> memo) {
        if (start >= end) {
            return 0;
        }
        String key = start + "|" + end;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            int max = Math.max(getMoneyAmount(n, start, i - 1, memo), getMoneyAmount(n, i + 1, end, memo)) + i;
            min = Math.min(min, max);
        }
        memo.put(key, min);
        return min;
    }
}