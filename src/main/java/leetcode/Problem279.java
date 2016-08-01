package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/perfect-squares/
 */
public class Problem279 {
    public int numSquares(int n) {
        int x = (int) Math.sqrt(n);
        List<Integer> squares = new ArrayList<>();
        for (int i = x; i >= 1; i--) {
            squares.add(i * i);
        }
        Map<Integer, Integer> memo = new HashMap<>();
        return numSquares(n, squares, memo);
    }

    private int numSquares(int n, List<Integer> squares, Map<Integer, Integer> memo) {
        if (n < 0) {
            return Integer.MAX_VALUE;
        }
        if (n == 0) {
            return 0;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int min = Integer.MAX_VALUE;
        for (int square : squares) {
            int val = numSquares(n - square, squares, memo);
            min = Math.min(min, val);
        }
        memo.put(n, min + 1);
        return min + 1;
    }
}
