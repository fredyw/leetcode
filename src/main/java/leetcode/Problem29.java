package leetcode;

/**
 * https://oj.leetcode.com/problems/divide-two-integers/
 */
public class Problem29 {
    public int divide(int dividend, int divisor) {
        long result = 0;
        boolean negative = false;
        if ((dividend < 0 && divisor > 0)) {
            negative = true;
            dividend = ~dividend + 1;
        } else if (dividend > 0 && divisor < 0) {
            negative = true;
            divisor = ~divisor + 1;
        } else if (dividend < 0 && divisor < 0) {
            dividend = ~dividend + 1;
            divisor = ~divisor + 1;
        }
        long tmp = dividend;
        while (tmp > 0) {
            tmp -= divisor;
            result++;
        }
        result = (negative) ? ~result + 1 : result;
        if (result >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) result;
    }
    
    public static void main(String[] args) {
        Problem29 prob = new Problem29();
        System.out.println(prob.divide(8, 2));
        System.out.println(prob.divide(100, 2));
        System.out.println(prob.divide(50, 5));
        System.out.println(prob.divide(250, 50));
        System.out.println(prob.divide(-250, -50));
        System.out.println(prob.divide(-250, 50));
        System.out.println(prob.divide(250, -50));
        System.out.println(prob.divide(2, 3));
        System.out.println(prob.divide(2147483647, 2));
    }
}
