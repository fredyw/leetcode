package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/last-stone-weight-ii/
 */
public class Problem1049 {
    public int lastStoneWeightII(int[] stones) {
        return lastStoneWeight(stones, 0, 0, new HashMap<>());
    }

    private static int lastStoneWeight(int[] stones, int index, int result, Map<String, Integer> memo) {
        if (index == stones.length) {
            if (result < 0) {
                return Integer.MAX_VALUE;
            }
            return result;
        }
        String key = index + "|" + result;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int a = lastStoneWeight(stones, index + 1, result + stones[index], memo);
        int b = lastStoneWeight(stones, index + 1, result - stones[index], memo);
        int min = Math.min(a, b);
        memo.put(key, min);
        return min;
    }
}
