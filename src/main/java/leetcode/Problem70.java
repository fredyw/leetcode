package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://oj.leetcode.com/problems/climbing-stairs/
 */
public class Problem70 {
    public int climbStairs(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return climbStairs(n, 1, memo) + climbStairs(n, 2, memo);
    }

    private int climbStairs(int n, int accu, Map<Integer, Integer> memo) {
        if (accu == n) {
            return 1;
        } else if (accu > n) {
            return 0;
        } else {
            int x = 0;
            if (memo.containsKey(accu + 1)) {
                x = memo.get(accu + 1);
            } else {
                x = climbStairs(n, accu + 1, memo);
            }
            memo.put(accu + 1, x);
            int y = 0;
            if (memo.containsKey(accu + 2)) {
                y = memo.get(accu + 2);
            } else {
                y = climbStairs(n, accu + 2, memo);
            }
            memo.put(accu + 2, y);
            return x + y;
        }
    }
}