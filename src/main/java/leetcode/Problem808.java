package leetcode;

/**
 * https://leetcode.com/problems/soup-servings/
 */
public class Problem808 {
    public double soupServings(int N) {
        // TODO
        return soupServings(N, N);
    }

    private double soupServings(int a, int b) {
        if (a <= 0 && b <= 0) {
            return 0.5;
        }
        if (a <= 0) {
            return 0;
        }
        if (b <= 0) {
            return 1;
        }
        double result = 0.25 * (soupServings(a, b - 100) +
            soupServings(a - 25, b - 75) +
            soupServings(a - 50, b - 50) +
            soupServings(a - 75, b - 25));
        return result;
    }

    public static void main(String[] args) {
        Problem808 prob = new Problem808();
        System.out.println(prob.soupServings(50)); // 0.625
        System.out.println(prob.soupServings(40)); // 0.625
        System.out.println(prob.soupServings(100)); // 0.71875
    }
}
