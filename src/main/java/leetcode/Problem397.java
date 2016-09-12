package leetcode;

/**
 * https://leetcode.com/problems/integer-replacement/
 */
public class Problem397 {
    public int integerReplacement(int n) {
        return (int) longReplacement(n);
    }

    private long longReplacement(long n) {
        if (n == 1) {
            return 0;
        }
        if (n % 2 == 0) {
            return longReplacement(n / 2) + 1;
        }
        long a = longReplacement(n - 1) + 1;
        long b = longReplacement(n + 1) + 1;
        return Math.min(a, b);
    }
}
