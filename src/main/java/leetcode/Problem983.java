package leetcode;

/**
 * https://leetcode.com/problems/minimum-cost-for-tickets/
 */
public class Problem983 {
    public int mincostTickets(int[] days, int[] costs) {
        return minCostTickets(days, costs, 0);
    }

    private static int minCostTickets(int[] days, int[] costs, int index) {
        if (index == days.length) {
            return 0;
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
            int c = minCostTickets(days, costs, j) + costs[i];
            min = Math.min(min, c);
        }
        return min;
    }

    public static void main(String[] args) {
        Problem983 prob = new Problem983();
        System.out.println(prob.mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15})); // 11
        System.out.println(prob.mincostTickets(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[]{2, 7, 15})); // 17
    }
}
