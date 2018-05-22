package leetcode;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;

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
        Map<Integer, Integer> map = new HashMap<>();
        int maxProfit = 0;
        for (int i = 0; i < dp.length; i++) {
            maxProfit = Math.max(maxProfit, dp[i].profit);
            map.put(dp[i].difficulty, maxProfit);
        }
        int result = 0;
        TreeSet<Entry<Integer, Integer>> set = new TreeSet<>(
            Comparator.comparingInt(Entry::getKey));
        set.addAll(map.entrySet());
        for (int i = 0; i < worker.length; i++) {
            Entry<Integer, Integer> entry = set.floor(new SimpleImmutableEntry<>(worker[i], 0));
            if (entry != null) {
                result += entry.getValue();
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
    }
}
