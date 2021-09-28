package leetcode;

import java.util.TreeSet;

/**
 * https://leetcode.com/problems/seat-reservation-manager/
 */
public class Problem1845 {
    private static class SeatManager {
        private final TreeSet<Integer> set = new TreeSet<>();

        public SeatManager(int n) {
            for (int i = 1; i <= n; i++) {
                set.add(i);
            }
        }

        public int reserve() {
            return set.pollFirst();
        }

        public void unreserve(int seatNumber) {
            set.add(seatNumber);
        }
    }
}
