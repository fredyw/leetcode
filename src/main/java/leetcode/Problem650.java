package leetcode;

/**
 * https://leetcode.com/problems/2-keys-keyboard/
 */
public class Problem650 {
    public int minSteps(int n) {
        return minSteps(1, n, 1);
    }

    private static int minSteps(int n, int m, int x) {
        if (n == m) {
            return 1;
        } else if (n > m) {
            return 0;
        }
        int a = minSteps(n - x, m, x) + 1;
        int b = minSteps(n, m, n);
        int min = Math.min(a, b);
        return min;
    }

    public static void main(String[] args) {
        Problem650 prob = new Problem650();
        System.out.println(prob.minSteps(3)); // 3
    }
}
