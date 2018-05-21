package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/most-profit-assigning-work/
 */
public class Problem826 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        // TODO
        DifficultyProfit[] dp = new DifficultyProfit[difficulty.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new DifficultyProfit(difficulty[i], profit[i]);
        }
        Arrays.sort(dp, Comparator.comparingInt(a -> a.difficulty));
        int maxProfit = 0;
        for (int i = 0; i < dp.length; i++) {
            maxProfit = Math.max(maxProfit, dp[i].profit);
            dp[i].profit = maxProfit;
        }
        return 0;
    }

    private static class DifficultyProfit {
        private final int difficulty;
        private int profit;

        public DifficultyProfit(int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;
        }

        @Override
        public String toString() {
            return difficulty + " -> " + profit;
        }
    }

    public static void main(String[] args) {
        Problem826 prob = new Problem826();
        System.out.println(prob.maxProfitAssignment(new int[]{2, 4, 6, 8, 10},
            new int[]{10, 20, 30, 40, 50}, new int[]{4, 5, 6, 7})); // 100
        System.out.println(prob.maxProfitAssignment(new int[]{2, 4, 6, 8, 10},
            new int[]{10, 5, 30, 40, 50}, new int[]{4, 5, 6, 7})); // 80
    }
}
