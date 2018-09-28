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
        int max = stoneGame(piles, 0, piles.length - 1);
        System.out.println(max);
        return max >= sum - max;
    }

    private static int stoneGame(int[] piles, int i, int j) {
        if (i >= j) {
            return 0;
        }
        int val = stoneGame(piles, i + 1, j - 1);
        int a = val + piles[i];
        int b = val + piles[j];
        return Math.max(a, b);
    }

    public static void main(String[] args) {
        Problem877 prob = new Problem877();
        System.out.println(prob.stoneGame(new int[]{5, 3, 4, 5})); // true
//        System.out.println(prob.stoneGame(new int[]{5, 3, 4, 6})); // true
//        System.out.println(prob.stoneGame(new int[]{1, 1, 1, 1})); // true
//        System.out.println(prob.stoneGame(new int[]{7, 3, 8, 2, 9, 10})); // true
    }
}
