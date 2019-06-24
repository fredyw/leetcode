package leetcode;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/car-pooling/
 */
public class Problem1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<Trip> queue = new PriorityQueue<>((a, b) -> {
            int cmp = a.location - b.location;
            if (cmp == 0) {
                // End location should come first.
                return Integer.compare(b.passengers, a.passengers);
            }
            return cmp;
        });
        for (int[] trip : trips) {
            queue.add(new Trip(-trip[0], trip[1]));
            queue.add(new Trip(trip[0], trip[2]));
        }
        int cap = capacity;
        while (!queue.isEmpty()) {
            cap += queue.poll().passengers;
            if (cap < 0) {
                return false;
            }
        }
        return true;
    }

    private static class Trip {
        private final int passengers;
        private final int location;

        public Trip(int passengers, int location) {
            this.passengers = passengers;
            this.location = location;
        }
    }
}
