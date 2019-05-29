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

    public static void main(String[] args) {
        Problem1049 prob = new Problem1049();
        // 7 + 4 + 1 = 12
        // 8 + 2 + 1 = 11
        // sum = 23
        System.out.println(prob.lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1})); // 1
        System.out.println(prob.lastStoneWeightII(new int[]{2, 7, 4, 1, 1, 8})); // 1
        // 7 + 4 + 2 = 13
        // 10 + 1 + 1 = 12
        System.out.println(prob.lastStoneWeightII(new int[]{2, 7, 4, 1, 1, 10})); // 1
        System.out.println(prob.lastStoneWeightII(new int[]{2, 7, 4, 1, 0, 10})); // 0
        System.out.println(prob.lastStoneWeightII(new int[]{13, 10})); // 3
        System.out.println(prob.lastStoneWeightII(new int[]{2, 7, 15})); // 6
        // 7 + 4 + 2 + 1 = 14
        // 10 + 3 + 13
        System.out.println(prob.lastStoneWeightII(new int[]{2, 7, 4, 1, 3, 10})); // 1


    }
}
