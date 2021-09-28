package leetcode;

/**
 * https://leetcode.com/problems/seat-reservation-manager/
 */
public class Problem1845 {
    private static class SeatManager {
        public SeatManager(int n) {
            // TODO
        }

        public int reserve() {
            // TODO
            return 0;
        }

        public void unreserve(int seatNumber) {
            // TODO
        }
    }

    public static void main(String[] args) {
        SeatManager seatManager = new SeatManager(5); // Initializes a SeatManager with 5 seats.
        System.out.println(seatManager.reserve()); // All seats are available, so return the lowest numbered seat, which is 1.
        System.out.println(seatManager.reserve()); // The available seats are [2,3,4,5], so return the lowest of them, which is 2.
        seatManager.unreserve(2); // Unreserve seat 2, so now the available seats are [2,3,4,5].
        System.out.println(seatManager.reserve()); // The available seats are [2,3,4,5], so return the lowest of them, which is 2.
        System.out.println(seatManager.reserve()); // The available seats are [3,4,5], so return the lowest of them, which is 3.
        System.out.println(seatManager.reserve()); // The available seats are [4,5], so return the lowest of them, which is 4.
        System.out.println(seatManager.reserve()); // The only available seat is seat 5, so return 5.
        seatManager.unreserve(5); // Unreserve seat 5, so now the available seats are [5].
    }
}
