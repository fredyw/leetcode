package leetcode;

/**
 * https://leetcode.com/problems/teemo-attacking/
 */
public class Problem495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int total = 0;
        if (timeSeries.length == 0) {
            return total;
        }
        for (int i = 0; i < timeSeries.length - 1; i++) {
            if (timeSeries[i] + duration <= timeSeries[i + 1]) {
                total += duration;
            } else {
                total += timeSeries[i + 1] - timeSeries[i];
            }
        }
        total += duration;
        return total;
    }
}
