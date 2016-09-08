package leetcode;

/**
 * https://leetcode.com/problems/valid-perfect-square/
 */
public class Problem367 {
    public boolean isPerfectSquare(int num) {
        double sqrt = sqrt(num);
        int isqrt = (int) sqrt(num);
        System.out.println(sqrt + " vs " + isqrt);
        double diff = Math.abs((int) sqrt - sqrt);
//        System.out.println("diff: " + diff + " --> " + sqrt + " --> " + (int) (diff * 100));
        // TODO:
        return (int) (diff * 100) <= 5;
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

    public static void main(String[] args) {
        Problem367 prob = new Problem367();
        System.out.println(prob.isPerfectSquare(100));
        System.out.println(prob.isPerfectSquare(4));
        System.out.println(prob.isPerfectSquare(3));
        System.out.println(prob.isPerfectSquare(25));
        System.out.println(prob.isPerfectSquare(26));
        System.out.println(prob.isPerfectSquare(681));
        System.out.println(prob.isPerfectSquare(36));
        System.out.println(prob.isPerfectSquare(362));
    }
}
