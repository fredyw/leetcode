package leetcode;

/**
 * https://leetcode.com/problems/number-of-digit-one/
 */
public class Problem233 {
    public int countDigitOne(int n) {
        if (n <= 0)
            return 0;
        if (n < 10)
            return 1;
        System.out.println("n="+ n);
        int t = (n % 10 + 1) * countDigitOne2(new Integer(n / 10).toString());
        if (n % 10 >= 1) {
            return countDigitOne(n / 10 - 1) * 10 + (n / 10 + 1) + t;
        } else {
            return countDigitOne(n / 10 - 1) * 10 + n / 10 + t;
        }
        
//        int result = 0;
//        for (int i = 1; i <= n; i *= 10) {
//            int j = n / i;
//            System.out.println(j);
//        }
//        return result;
//        
//        int result = 0;
//        for (int i = 1; i <= n; i++) {
//            int digit = countDigit(i);
//            int tmp = i;
//            for (int d = digit-1; d >= 0; d--) {
//                int divisor = (int) Math.pow(10, d);
//                int a = tmp / divisor;
//                if (a == 1) {
//                    result++;
//                }
//                tmp = tmp % divisor;
//            }
//        }
//        return result;
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
    
    public static int countDigitOne2(String s) {
        int res = 0; 
        char[] arry = s.toCharArray();
        for(char c : arry) {
            if(c == '1') {
                res += 1;
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        Problem233 prob = new Problem233();
//        System.out.println(prob.countDigitOne(100)); // 21
//        System.out.println(prob.countDigitOne(1000)); // 301
//        System.out.println(prob.countDigitOne(10000)); // 4001
        System.out.println(prob.countDigitOne(1811)); // 1376
//        System.out.println(prob.countDigitOne(181)); // 121
//        System.out.println(prob.countDigitOne(121)); // 55
//        System.out.println(prob.countDigitOne(12341)); // 8117
//        System.out.println(prob.countDigitOne(13)); // 6
//        System.out.println(prob.countDigitOne(824883294)); // 767944060
    }
}
