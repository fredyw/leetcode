package leetcode;

/**
 * https://leetcode.com/problems/prime-arrangements/
 */
public class Problem1175 {
    public int numPrimeArrangements(int n) {
        boolean[] primes = new boolean[n + 1];
        for (int i = 2; i < primes.length; i++) {
            primes[i] = true;
        }
        for (int i = 2; i * i <= n; i++) {
            if (!primes[i]) {
                continue;
            }
            for (int j = i * i; j <= n; j += i) {
                primes[j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                count++;
            }
        }
        return (int) ((factorial(count) * factorial(n - count)) % 1000000007);
    }

    private static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result = (result * i) % 1000000007;
        }
        return result % 1000000007;
    }
}
