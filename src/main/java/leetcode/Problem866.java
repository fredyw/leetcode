package leetcode;

/**
 * https://leetcode.com/problems/prime-palindrome/
 */
public class Problem866 {
    public int primePalindrome(int N) {
        if (8 <= N && N <= 11) {
            return 11;
        }
        for (int x = 1; x < 100000; x++) {
            String s = Integer.toString(x);
            String r = new StringBuilder(s).reverse().toString().substring(1);
            int y = Integer.parseInt(s + r);
            if (y >= N && isPrime(y)) {
                return y;
            }
        }
        return -1;
    }

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
