package leetcode;

/**
 * https://leetcode.com/problems/number-of-digit-one/
 */
public class Problem233 {
    public int countDigitOne(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            int digit = countDigit(i);
            int tmp = i;
            for (int d = digit-1; d >= 0; d--) {
                int divisor = (int) Math.pow(10, d);
                int a = tmp / divisor;
                if (a == 1) {
                    result++;
                }
                tmp = tmp % divisor;
            }
        }
        return result;
    }

    private int countDigit(int n) {
        int tmp = n;
        int digit = 0;
        while (tmp != 0) {
            digit++;
            tmp = tmp / 10;
        }
        return digit;
    }
    
    public static void main(String[] args) {
        Problem233 prob = new Problem233();
//        System.out.println(prob.countDigit(824883294));
//        System.out.println(prob.countDigitOne(12341));
//        System.out.println(prob.countDigitOne(13));
        System.out.println(prob.countDigitOne(824883294));
    }
}
