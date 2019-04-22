package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/two-city-scheduling/
 */
public class Problem1029 {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (c1, c2) -> Math.abs(c2[0] - c2[1]) - Math.abs(c1[0] - c1[1]));
        int answer = 0;
        int aCount = 0;
        int bCount = 0;
        for (int[] cost : costs) {
            if (aCount == costs.length / 2) {
                answer += cost[1];
                bCount++;
            } else if (bCount == costs.length / 2) {
                answer += cost[0];
                aCount++;
            } else {
                if (cost[0] <= cost[1]) {
                    answer += cost[0];
                    aCount++;
                } else {
                    answer += cost[1];
                    bCount++;
                }
            }
        }
        return answer;
    }
}
