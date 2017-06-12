package leetcode;

/**
 * https://leetcode.com/problems/powx-n/
 */
public class Problem50 {
    public double pow(double x, int n) {
        if (n >= 0) {
            return powPositive(x, n);
        }
        return powNegative(x, n);
    }

    private double powPositive(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n % 2 == 0) {
            return powPositive(x * x, n / 2);
        }
        return x * powPositive(x * x, n / 2);
    }

    private double powNegative(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n % 2 == 0) {
            return powNegative(x * x, n / 2);
        }
        return powNegative(x * x, n / 2) / x;
    }
}
