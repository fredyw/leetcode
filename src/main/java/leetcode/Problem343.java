package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/integer-break/
 */
public class Problem343 {
    public int integerBreak(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return integerBreak(n, memo);
    }

    private int integerBreak(int n, Map<Integer, Integer> memo) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int max = 0;
        for (int i = 1; i < n; i++) {
            int x1 = n - i;
            int y1 = n - x1;
            int x2 = integerBreak(x1, memo);
            int x = Math.max(x1, x2);
            int y2 = integerBreak(y1, memo);
            int y = Math.max(y1, y2);
            max = Math.max(x * y, max);
        }
        memo.put(n, max);
        return max;
    }
}
