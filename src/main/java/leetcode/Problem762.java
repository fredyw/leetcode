package leetcode;

/**
 * https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/
 */
public class Problem762 {
    public int countPrimeSetBits(int L, int R) {
        // TODO

        return 0;
    }

    private static boolean isPrime(int n) {
        return n == 2 || n == 3 || n == 5 || n == 7 || n == 11 ||
            n == 13 || n == 17 || n == 19;
    }

    public static void main(String[] args) {
        Problem762 prob = new Problem762();
        System.out.println(prob.countPrimeSetBits(6, 10)); // 4
        System.out.println(prob.countPrimeSetBits(10, 15)); // 5
    }
}
