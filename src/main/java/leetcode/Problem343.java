package leetcode;

/**
 * https://leetcode.com/problems/integer-break/
 */
public class Problem343 {
    public int integerBreak(int n) {
        if (n == 1) {
            return 1;
        }
        int x = n / 2;
        int y = n - x;
        int n1 = integerBreak(x);
        int n2 = integerBreak(y);
        int multiply1 = x * y;
        int multiple2 = n1 * n2;
        int max = Math.max(multiply1, multiple2);
        return max;
    }

    public static void main(String[] args) {
        Problem343 prob = new Problem343();
        System.out.println(prob.integerBreak(2)); // 1
        System.out.println(prob.integerBreak(10)); // 36
        System.out.println(prob.integerBreak(1)); // 1
        System.out.println(prob.integerBreak(14)); // 162
    }
}
