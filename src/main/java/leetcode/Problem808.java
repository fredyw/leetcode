package leetcode;

/**
 * https://leetcode.com/problems/soup-servings/
 */
public class Problem808 {
    public double soupServings(int N) {
        int div = N / 25;
        int mod = N % 25;
        N = div + (mod == 0 ? 0 : 1);
        if (N >= 500) {
            return 1;
        }
        Double[][] memo = new Double[N + 1][N + 1];
        return soupServings(N, N, memo);
    }

    private double soupServings(int a, int b, Double[][] memo) {
        if (a <= 0 && b <= 0) {
            return 0.5;
        }
        if (a <= 0) {
            return 1;
        }
        if (b <= 0) {
            return 0;
        }
        if (memo[a][b] != null) {
            return memo[a][b];
        }
        double result = 0.25 * (
            soupServings(a - 4, b, memo) +
            soupServings(a - 3, b - 1, memo) +
            soupServings(a - 2, b - 2, memo) +
            soupServings(a - 1, b - 3, memo)
        );
        memo[a][b] = result;
        return result;
    }
}
