package leetcode;

/**
 * https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/
 */
public class Problem1523 {
    public int countOdds(int low, int high) {
        double n = (high - low + 1) / 2.0;
        if (low % 2 != 0 || high % 2 != 0) {
            return (int) Math.ceil(n);
        }
        return (int) Math.floor(n);
    }
}
