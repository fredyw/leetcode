package leetcode;

/**
 * https://leetcode.com/problems/number-of-digit-one/
 */
public class Problem233 {
    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n < 10) {
            return 1;
        }
        int remainder = (n % 10) + 1;
        int t = remainder * countDigitOne(Integer.toString(n / 10));
        if (n % 10 >= 1) {
            return countDigitOne(n / 10 - 1) * 10 + (n / 10 + 1) + t;
        } else {
            return countDigitOne(n / 10 - 1) * 10 + n / 10 + t;
        }
    }

    public static int countDigitOne(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                count += 1;
            }
        }
        return count;
    }
}
