package leetcode;

/**
 * https://leetcode.com/problems/power-of-four/
 */
public class Problem342 {
    public boolean isPowerOfFour(int num) {
        double dval = Math.log10(num) / Math.log10(4);
        int ival = (int) dval;
        return (dval - ival == 0);
    }
}
