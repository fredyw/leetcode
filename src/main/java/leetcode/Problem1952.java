package leetcode;

/**
 * https://leetcode.com/problems/three-divisors/
 */
public class Problem1952 {
    public boolean isThree(int n) {
        if (n == 1) {
            return false;
        }
        // Having 3 divisors means 1, n and sqrt(n).
        double d = Math.sqrt(n);
        int i = (int) d;
        if (d - i > 0) {
            return false;
        }
        for (int j = 2; j < n; j++) {
            if (i == j) {
                continue;
            }
            if (n % j == 0) {
                return false;
            }
        }
        return true;
    }
}
