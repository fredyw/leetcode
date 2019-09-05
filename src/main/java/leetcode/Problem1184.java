package leetcode;

/**
 * https://leetcode.com/problems/distance-between-bus-stops/
 */
public class Problem1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int[] sums = new int[distance.length];
        int totalSum = distance[0];
        for (int i = 1; i < distance.length; i++) {
            sums[i] = distance[i - 1] + sums[i - 1];
            totalSum += distance[i];
        }
        int val1 = sums[Integer.max(start, destination)] - sums[Integer.min(start, destination)];
        int val2 = totalSum - val1;
        return Integer.min(val1, val2);
    }
}
