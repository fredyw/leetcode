package leetcode;

/**
 * https://leetcode.com/problems/card-flipping-game/
 */
public class Problem822 {
    public int flipgame(int[] fronts, int[] backs) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem822 prob = new Problem822();
        System.out.println(prob.flipgame(new int[]{1, 2, 4, 4, 7}, new int[]{1, 3, 4, 1, 3})); // 2
        System.out.println(prob.flipgame(new int[]{2}, new int[]{3})); // 2
        System.out.println(prob.flipgame(new int[]{3}, new int[]{2})); // 2
    }
}
