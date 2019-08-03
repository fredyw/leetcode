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
        return stoneGame(piles, 1, 0, totalSum, new Integer[piles.length * 2][piles.length + 1]);
    }

    private static int stoneGame(int[] piles, int m, int index, int totalSum, Integer[][] memo) {
        if (memo[index][m] != null) {
            return memo[index][m];
        }
        int answer = 0;
        int sum = 0;
        for (int i = index; i < index + (2 * m) && i < piles.length; i++) {
            sum += piles[i];
            int value = totalSum - stoneGame(piles, Math.max(i - index + 1, m), i + 1, totalSum - sum, memo);
            answer = Math.max(answer,  value);
        }
        memo[m][index] = answer;
        return answer;
    }
}
