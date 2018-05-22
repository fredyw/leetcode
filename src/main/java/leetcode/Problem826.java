package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/most-profit-assigning-work/
 */
public class Problem826 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
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
        int result = 0;
        for (int i = 0; i < worker.length; i++) {
            int idx = Arrays.binarySearch(dp, new DifficultyProfit(worker[i], 0),
                Comparator.comparingInt(a -> a.difficulty));
            if (idx < 0) {
                idx = -idx - 2;
                if (idx >= 0) {
                    result += dp[idx].profit;
                }
            } else {
                result += dp[idx].profit;
            }
        }
        return result;
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
//        System.out.println(prob.maxProfitAssignment(
//            new int[]{2, 4, 6, 8, 10},
//            new int[]{10, 20, 30, 40, 50},
//            new int[]{4, 5, 6, 7})); // 100
        System.out.println(prob.maxProfitAssignment(
            new int[]{4, 4, 6, 8, 10},
            new int[]{10, 30, 30, 40, 50},
            new int[]{4, 5, 6, 7})); // 120
//        System.out.println(prob.maxProfitAssignment(
//            new int[]{2, 4, 6, 8, 10},
//            new int[]{10, 5, 30, 40, 50},
//            new int[]{4, 5, 6, 7})); // 80
//        System.out.println(prob.maxProfitAssignment(
//            new int[]{23, 30, 35, 35, 43, 46, 47, 81, 83, 98},
//            new int[]{8, 11, 11, 20, 33, 37, 60, 72, 87, 95},
//            new int[]{95, 46, 47, 97, 11, 35, 99, 56, 41, 92})); // 553
    }
}
