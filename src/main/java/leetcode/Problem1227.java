package leetcode;

/**
 * https://leetcode.com/problems/airplane-seat-assignment-probability/
 */
public class Problem1227 {
    public double nthPersonGetsNthSeat(int n) {
        return n == 1 ? 1 : 0.5;
    }
}
