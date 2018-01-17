package leetcode;

/**
 * https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/
 */
public class Problem762 {
    public int countPrimeSetBits(int L, int R) {
        int result = 0;
        for (int i = L; i <= R; i++) {
            int count = count(i);
            if (isPrime(count)) {
                result++;
            }
        }
        return result;
    }

    private static int count(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }

    private static boolean isPrime(int n) {
        return n == 2 || n == 3 || n == 5 || n == 7 || n == 11 ||
            n == 13 || n == 17 || n == 19;
    }
}
