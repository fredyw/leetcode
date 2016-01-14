package leetcode;

import java.util.TreeSet;

/**
 * https://leetcode.com/problems/super-ugly-number/
 */
public class Problem313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        TreeSet<Long> set = new TreeSet<>();
        for (int prime : primes) {
            set.add((long) prime);
        }
        set.add(1L);
        int i = 0;
        long result = 0;
        int primeIdx = -1;
        while (i < n) {
            result = set.pollFirst();
            for (int j = 0; j <= primeIdx; j++) {
                long newElement = result * primes[j];
                if (set.size() > 0 && newElement > set.last() && set.size() + i > n) {
                    break;
                }
                set.add(newElement);
            }
            i++;
            if (primeIdx < primes.length - 1) {
                primeIdx++;
            }
        }
        return (int) result;
    }
}
