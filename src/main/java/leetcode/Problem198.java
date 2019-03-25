package leetcode;

/**
 * https://leetcode.com/problems/house-robber/
 */
public class Problem198 {
    public int rob(int[] num) {
        Integer[][] memo = new Integer[num.length][2];
        int a = rob(num, 0, true, memo);
        int b = rob(num, 0, false, memo);
        return Math.max(a, b);
    }

    private static int rob(int[] num, int index, boolean rob, Integer[][] memo) {
        if (index == num.length) {
            return 0;
        }
        if (memo[index][rob ? 1 : 0] != null) {
            return memo[index][rob ? 1 : 0];
        }
        int max = 0;
        if (rob) {
            max = Math.max(max, rob(num, index + 1, false, memo) + num[index]);
        } else {
            int a = rob(num, index + 1, true, memo);
            int b = rob(num, index + 1, false, memo);
            max = Math.max(max, Math.max(a, b));
        }
        memo[index][rob ? 1 : 0] = max;
        return max;
    }
}
