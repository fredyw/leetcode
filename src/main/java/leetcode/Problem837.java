package leetcode;

/**
 * https://leetcode.com/problems/new-21-game/
 */
public class Problem837 {
    public double new21Game(int N, int K, int W) {
        return new21Game(N, K, W, 0);
    }

    private static double new21Game(int n, int k, int w, int val) {
        if (val >= k) {
            if (val <= n) {
                return 1;
            }
            return 0;
        }
        double sum = 0;
        for (int i = 1; i <= w; i++) {
            double p = new21Game(n, k, w, val + i) * (1.0 / w);
            sum += p;
        }
        return sum;
    }

    public static void main(String[] args) {
        Problem837 prob = new Problem837();
        System.out.println(prob.new21Game(10, 1, 10)); // 1.00000
        System.out.println(prob.new21Game(6, 1, 10)); // 0.60000
        System.out.println(prob.new21Game(21, 17, 10)); // 0.73278
        System.out.println(prob.new21Game(2, 2, 4)); // 0.3125
        System.out.println(prob.new21Game(10, 2, 10)); // 0.99
    }
}
