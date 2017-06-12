package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/triangle/
 */
public class Problem120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        Map<String, Integer> memo = new HashMap<>();
        return minimumTotal(triangle, 0, 0, memo);
    }

    private int minimumTotal(List<List<Integer>> triangle, int row, int col,
                             Map<String, Integer> memo) {
        String key = row + "|" + col;
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int min = Integer.MAX_VALUE;
        if (row < triangle.size()) {
            int min1 = minimumTotal(triangle, row + 1, col, memo);
            int min2 = minimumTotal(triangle, row + 1, col + 1, memo);
            min = Math.min(min1, min2) + triangle.get(row).get(col);
            memo.put(key, min);
        }
        return min;
    }
}