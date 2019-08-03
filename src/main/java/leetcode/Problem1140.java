package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/stone-game-ii/
 */
public class Problem1140 {
    public int stoneGameII(int[] piles) {
        int totalSum = 0;
        for (int pile : piles) {
            totalSum += pile;
        }
        return stoneGame(piles, 1, 0, totalSum, new HashMap<>());
    }

    private static int stoneGame(int[] piles, int m, int index, int totalSum, Map<String, Integer> memo) {
        String key = m + "," + index;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int answer = 0;
        for (int i = 1; i <= 2 * m; i++) {
            int sum = 0;
            for (int j = index; j < index + i && j < piles.length; j++) {
                sum += piles[j];
                int value = totalSum - stoneGame(piles, Math.max(i, m), j + 1, totalSum - sum, memo);
                answer = Math.max(answer,  value);
            }
        }
        memo.put(key, answer);
        return answer;
    }

    public static void main(String[] args) {
        Problem1140 prob = new Problem1140();
        System.out.println(prob.stoneGameII(new int[]{2, 3, 9, 4})); // 6
        System.out.println(prob.stoneGameII(new int[]{2, 7, 9, 4, 4})); // 10
        System.out.println(prob.stoneGameII(new int[]{2, 3, 4})); // 5
        System.out.println(prob.stoneGameII(new int[]{2})); // 2
        System.out.println(prob.stoneGameII(new int[]{2, 3})); // 5
        System.out.println(prob.stoneGameII(new int[]{6, 4, 2, 8, 1, 8, 6, 6, 2})); // 24
    }
}
