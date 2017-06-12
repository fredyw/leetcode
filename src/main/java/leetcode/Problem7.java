package leetcode;

/**
 * https://leetcode.com/problems/reverse-integer/
 */
public class Problem7 {
    public int reverse(int x) {
        int n = 0;
        int tmp = x;
        while (tmp != 0) {
            n++;
            tmp /= 10;
        }
        // use long to check for an overflow
        long newValue = 0;
        for (int i = n; i > 0; i--) {
            int y = x % 10;
            newValue += y * (long) Math.pow(10, i - 1);
            x /= 10;
        }
        if (newValue > Integer.MAX_VALUE || newValue < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) newValue;
    }
}
