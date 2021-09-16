package leetcode;

/**
 * https://leetcode.com/problems/stone-game-vii/
 */
public class Problem1690 {
    public int stoneGameVII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        Integer[][] memo = new Integer[stones.length][stones.length];
        return stoneGame(stones, sum, 0, stones.length - 1, memo);
    }

    private static int stoneGame(int[] stones, int sum, int left, int right,
                                 Integer[][] memo) {
        if (left == right) {
            return 0;
        }
        if (memo[left][right] != null) {
            return memo[left][right];
        }
        int leftSum = sum - stones[left];
        int a =  leftSum - stoneGame(stones, leftSum, left + 1, right, memo);
        int rightSum = sum - stones[right];
        int b = rightSum - stoneGame(stones, rightSum, left, right - 1, memo);
        memo[left][right] = Math.max(a, b);
        return memo[left][right];
    }
}
