package leetcode;

/**
 * https://leetcode.com/problems/coin-change-2/
 */
public class Problem518 {
    public int change(int amount, int[] coins) {
        Result result = new Result();
        change(amount, coins, result);
        return result.result;
    }

    private static class Result {
        private int result;
    }

    private static void change(int amount, int[] coins, Result result) {
        if (amount <= 0) {
            if (amount == 0) {
                result.result++;
            }
            return;
        }
        for (int coin : coins) {
            change(amount - coin, coins, result);
        }
    }

    public static void main(String[] args) {
        Problem518 prob = new Problem518();
        System.out.println(prob.change(5, new int[]{1, 2, 5})); // 4
//        System.out.println(prob.change(3, new int[]{2})); // 0
//        System.out.println(prob.change(10, new int[]{10})); // 1
    }
}