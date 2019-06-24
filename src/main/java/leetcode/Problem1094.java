package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/car-pooling/
 */
public class Problem1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> {
            int cmp = Integer.compare(a[1], b[1]);
            if (cmp == 0) {
                return Integer.compare(a[2], b[2]);
            }
            return cmp;
        });
        int cap = capacity;
        PriorityQueue<NumPassengersEndLocation> queue = new PriorityQueue<>(
            Comparator.comparingInt(a -> a.endLocation));
        for (int i = 0; i < trips.length; i++) {
            int numPassengers = trips[i][0];
            int startLocation = trips[i][1];
            int endLocation = trips[i][2];
            if (!queue.isEmpty() && queue.peek().endLocation <= startLocation) {
                cap += queue.remove().numPassengers;
            }
            cap -= numPassengers;
            if (cap < 0) {
                return false;
            }
            queue.add(new NumPassengersEndLocation(numPassengers, endLocation));
        }
        return true;
    }

    private static class NumPassengersEndLocation {
        private final int numPassengers;
        private final int endLocation;

        public NumPassengersEndLocation(int numPassengers, int endLocation) {
            this.numPassengers = numPassengers;
            this.endLocation = endLocation;
        }
    }

    public static void main(String[] args) {
        Problem1094 prob = new Problem1094();
//        System.out.println(prob.carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 4)); // false
//        System.out.println(prob.carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 5)); // true
//        System.out.println(prob.carPooling(new int[][]{{2, 1, 5}, {3, 5, 7}}, 3)); // true
//        System.out.println(prob.carPooling(new int[][]{{3, 2, 7}, {3, 7, 9}, {8, 3, 9}}, 11)); // true
        System.out.println(prob.carPooling(new int[][]{{3, 2, 8}, {4, 4, 6}, {10, 8, 9}}, 11)); // true
    }
}
