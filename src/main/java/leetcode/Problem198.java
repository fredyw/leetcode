package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/house-robber/
 */
public class Problem198 {
    public int rob(int[] num) {
        Map<Integer, Integer> memo = new HashMap<>();
        int max1 = rob(num, 0, memo);
        int max2 = rob(num, 1, memo);
        if (max1 > max2) {
            return max1;
        }
        return max2;
    }

    private int rob(int[] num, int idx, Map<Integer, Integer> memo) {
        if (memo.containsKey(idx)) {
            return memo.get(idx);
        }
        if (idx == num.length - 1) {
            return num[idx];
        }
        if (idx >= num.length) {
            return 0;
        }
        int m1 = rob(num, idx + 2, memo);
        int m2 = rob(num, idx + 3, memo);
        int val = num[idx];
        if (m1 > m2) {
            memo.put(idx, val + m1);
            return val + m1;
        }
        memo.put(idx, val + m2);
        return val + m2;
    }
}
