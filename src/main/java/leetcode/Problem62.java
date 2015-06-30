package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/unique-paths/
 */
public class Problem62 {
    public int uniquePaths(int m, int n) {
        Map<String, Integer> memo = new HashMap<>();
        return uniquePaths(m, n, 1, 1, memo);
    }
    
    private int uniquePaths(int m, int n, int x, int y, Map<String, Integer> memo) {
        if (x > m || y > n) {
            return 0;
        }
        if (x == m && y == n) {
            return 1;
        }
        if (memo.containsKey(x + "|" + y)) {
            return memo.get(x + "|" + y);
        }
        int a = uniquePaths(m, n, x+1, y, memo);
        int b = uniquePaths(m, n, x, y+1, memo);
        int result = a + b;
        memo.put(x + "|" + y, result);
        return result;
    }
}
