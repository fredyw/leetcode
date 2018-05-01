package leetcode;

/**
 * https://leetcode.com/problems/card-flipping-game/
 */
public class Problem822 {
    public int flipgame(int[] fronts, int[] backs) {
        int[] set = new int[2000];
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < fronts.length; i++) {
            set[fronts[i]]++;
        }
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                continue;
            }
            if (set[fronts[i]] == 1) {
                result = Math.min(result, backs[i]);
            }
            // Flip
            set[backs[i]]++;
            set[fronts[i]]--;
            if (set[backs[i]] == 1) {
                result = Math.min(result, backs[i]);
            }
            // Restore
            set[backs[i]]--;
            set[fronts[i]]++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        Problem822 prob = new Problem822();
//        System.out.println(prob.flipgame(new int[]{1, 2, 4, 4, 7}, new int[]{1, 3, 4, 1, 3})); // 2
//        System.out.println(prob.flipgame(new int[]{2}, new int[]{3})); // 2
//        System.out.println(prob.flipgame(new int[]{3}, new int[]{2})); // 2
//        System.out.println(prob.flipgame(new int[]{3}, new int[]{3})); // 0
//        System.out.println(prob.flipgame(new int[]{1, 1}, new int[]{1, 2})); // 2
        System.out.println(prob.flipgame(new int[]{1, 1}, new int[]{2, 2})); // 1
    }
}
