package leetcode;

/**
 * https://leetcode.com/problems/gas-station/
 */
public class Problem134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int minIdx = 0;
        for (int i = 0; i < gas.length; i++) {
            int g = gas[i];
            int c = cost[i];
            int remaining = g - c;
            sum += remaining;
            if (sum < min) {
                min = sum;
                minIdx = i;
            }
        }
        if (sum < 0) {
            return -1;
        }
        return (minIdx + 1) % gas.length;
    }
}
