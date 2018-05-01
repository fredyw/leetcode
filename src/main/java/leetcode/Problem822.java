package leetcode;

/**
 * https://leetcode.com/problems/card-flipping-game/
 */
public class Problem822 {
    public int flipgame(int[] fronts, int[] backs) {
        boolean[] set = new boolean[2000];
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                set[fronts[i]] = true;
            }
        }
        for (int i = 0; i < fronts.length; i++) {
            if (!set[fronts[i]]) {
                result = Math.min(result, fronts[i]);
            }
            // Flip
            if (!set[backs[i]]) {
                result = Math.min(result, backs[i]);
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
