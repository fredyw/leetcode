package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/unique-binary-search-trees/
 */
public class Problem96 {
    /*
     * http://en.wikipedia.org/wiki/Catalan_number
     */
    public int numTrees(int n) {
        return numTrees(n, new HashMap<>());
    }

    private int numTrees(int n, Map<Integer, Integer> memo) {
        if (n == 0) {
            return 1;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += numTrees(i - 1, memo) * numTrees(n - i, memo);
        }
        memo.put(n, sum);
        return sum;
    }
}
