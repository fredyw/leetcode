package leetcode;

/**
 * https://leetcode.com/problems/power-of-two/
 */
public class Problem231 {
    public boolean isPowerOfTwo(int n) {
        double m = Math.log10(n) / Math.log10(2);
        double fraction = (long) m - m;
        return fraction == 0.0;
    }
}
