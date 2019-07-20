package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/corporate-flight-bookings/
 */
public class Problem1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1109 prob = new Problem1109();
        System.out.println(Arrays.toString(prob.corpFlightBookings(new int[][]{
            {1, 2, 10}, {2, 3, 20}, {2, 5, 25}
        }, 5))); // [10,55,45,25,25]
    }
}
