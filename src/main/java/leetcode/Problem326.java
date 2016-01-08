package leetcode;

/**
 * https://leetcode.com/problems/power-of-three/
 */
public class Problem326 {
    public boolean isPowerOfThree(int n) {
        double val = Math.log10(n) / Math.log10(3);
        int truncVal = (int) val;
        return (val - truncVal) == 0;
    }
}
