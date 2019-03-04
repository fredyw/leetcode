package leetcode;

/**
 * https://leetcode.com/problems/new-21-game/
 */
public class Problem837 {
    public double new21Game(int N, int K, int W) {
        Double[] memo = new Double[N + 1];
        return new21Game(N, K, W, 0, memo);
    }

    private static double new21Game(int n, int k, int w, int val, Double[] memo) {
        if (val >= k) {
            if (val <= n) {
                return 1;
            }
            return 0;
        }
        if (memo[val] != null) {
            return memo[val];
        }
        double sum = 0;
        for (int i = 1; i <= w; i++) {
            double p = new21Game(n, k, w, val + i, memo) * (1.0 / w);
            sum += p;
        }
        memo[val] = sum;
        return sum;
    }
}
