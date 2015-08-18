package leetcode;

/**
 * https://leetcode.com/problems/count-primes/
 */
public class Problem204 {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        // https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
        boolean[] primes = new boolean[n];
        for (int i = 2; i < n; i++) {
            primes[i] = true;
        }
        for (int i = 2; i * i < n; i++) {
            if (!primes[i]) {
                continue;
            }
            int k = i * i;
            int l = 0;
            for (int j = k; j < n; j = k + (l * i)) {
                primes[j] = false;
                l++;
            }
        }
        int result = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                result++;
            }
        }
        return result;
    }
}
