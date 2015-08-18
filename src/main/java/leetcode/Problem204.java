package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/count-primes/
 */
public class Problem204 {
    public int countPrimes(int n) {
        // https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
        int prime = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            set.add(i);
        }
        for (int i = 2; i <= n; i++) {
            if (!set.contains(i)) {
                continue;
            }
            for (int j = i; j <= n; j += i) {
                set.remove(j);
            }
            prime++;
        }
        return prime;
    }
    
    public static void main(String[] args) {
        Problem204 prob = new Problem204();
        System.out.println(prob.countPrimes(20));
        System.out.println(prob.countPrimes(999983));
    }
}
