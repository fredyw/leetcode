package leetcode;

/**
 * https://leetcode.com/problems/stone-game/
 */
public class Problem877 {
    public boolean stoneGame(int[] piles) {
        int sum = 0;
        for (int i = 0; i < piles.length; i++) {
            sum += piles[i];
        }
        int max = stoneGame(piles, 0, piles.length - 1, new Integer[piles.length][piles.length]);
        return max >= sum - max;
    }

    private static int stoneGame(int[] piles, int i, int j, Integer[][] memo) {
        if (i >= j) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        int a = stoneGame(piles, i + 2, j, memo) + piles[i];
        int b = stoneGame(piles, i, j - 2, memo) + piles[j];
        int c = stoneGame(piles, i + 1, j - 1, memo) + piles[i];
        int d = stoneGame(piles, i + 1, j - 1, memo) + piles[j];
        int max = Math.max(a, Math.max(Math.max(b, c), d));
        memo[i][j] = max;
        return max;
    }
}
