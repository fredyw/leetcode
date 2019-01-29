package leetcode;

/**
 * https://leetcode.com/problems/minimum-cost-for-tickets/
 */
public class Problem983 {
    public int mincostTickets(int[] days, int[] costs) {
        Integer[] memo = new Integer[days.length];
        return minCostTickets(days, costs, 0, memo);
    }

    private static int minCostTickets(int[] days, int[] costs, int index, Integer[] memo) {
        if (index == days.length) {
            return 0;
        }
        if (memo[index] != null) {
            return memo[index];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < costs.length; i++) {
            int nDays = 0;
            if (i == 0) {
                nDays = 1;
            } else if (i == 1) {
                nDays = 7;
            } else {
                nDays = 30;
            }
            int toDay = days[index] + nDays;
            int j = index + 1;
            for (; j < days.length; j++) {
                if (days[j] >= toDay) {
                    break;
                }
            }
            int c = minCostTickets(days, costs, j, memo) + costs[i];
            min = Math.min(min, c);
        }
        memo[index] = min;
        return min;
    }
}
