package leetcode;

/**
 * https://leetcode.com/problems/valid-perfect-square/
 */
public class Problem367 {
    public boolean isPerfectSquare(int num) {
        double sqrt = sqrt(num);
        int isqrt = (int) sqrt;
        return (isqrt * isqrt) == num;
    }

    private double sqrt(int x) {
        // using Newton's method
        // https://www.youtube.com/watch?v=2158QbsunA8
        double sqrt = sqrt(x, x);
        while (true) {
            double tmp = sqrt;
            sqrt = sqrt(sqrt, x);
            if (Double.isNaN(sqrt) || tmp - sqrt < 1) {
                break;
            }
        }
        return sqrt;
    }

    private double fx(double x, double y) {
        return (x * x) - y;
    }

    private double dfx(double x) {
        // the derivative of fx
        return 2 * x;
    }

    private double sqrt(double x, double y) {
        return x - (fx(x, y) / dfx(x));
    }
}
