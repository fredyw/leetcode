package leetcode;

/**
 * https://oj.leetcode.com/problems/factorial-trailing-zeroes/
 */
public class Problem172 {
    public int trailingZeroes(int n) {
        int result = 0;
        int exp = 1;
        long pow = (long) Math.pow(5, exp);
        while (pow <= n) {
            pow = (long) Math.pow(5, exp++);
            result += n / pow;
        }
        return result;
    }
}
