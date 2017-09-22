package leetcode;

/**
 * https://leetcode.com/problems/water-and-jug-problem/
 */
public class Problem365 {
    public boolean canMeasureWater(int x, int y, int z) {
        // http://www.math.tamu.edu/~dallen/hollywood/diehard/diehard.htm
        if (z == 0) {
            return true;
        }
        if ((x + y) >= z && gcd(x, y) == 1) {
            return true;
        }
        return false;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
