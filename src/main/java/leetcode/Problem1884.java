package leetcode;

/**
 * https://leetcode.com/problems/egg-drop-with-2-eggs-and-n-floors/
 */
public class Problem1884 {
    public int twoEggDrop(int n) {
        int eggs = 2;
        return twoEggDrop(n, eggs, new Integer[n + 1][eggs + 1]);
    }

    private static int twoEggDrop(int floors, int eggs, Integer[][] memo) {
        if (eggs == 1 || floors <= 1) {
            return floors;
        }
        if (memo[floors][eggs] != null) {
            return memo[floors][eggs];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= floors; i++) {
            int a = twoEggDrop(i - 1, eggs - 1, memo); // break
            int b = twoEggDrop(floors - i, eggs, memo); // does not break
            min = Math.min(min, 1 + Math.max(a, b));
        }
        memo[floors][eggs] = min;
        return min;
    }
}
