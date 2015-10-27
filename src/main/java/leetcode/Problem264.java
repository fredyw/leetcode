package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/ugly-number-ii/
 */
public class Problem264 {
    public int nthUglyNumber(int n) {
        int i = 0;
        int count = 0;
        while (count < n) {
            if (isUgly(i)) {
                count++;
            }
            i++;
        }
        if (i-1 < 0) {
            return 0;
        }
        return i-1;
    }

    private boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        int[] primes = new int[]{2, 3, 5};
        Set<Integer> pf = new HashSet<>();
        isUgly(num, primes, pf);
        for (int prime : primes) {
            pf.remove(prime);
        }
        return pf.isEmpty();
    }

    private void isUgly(int num, int[] primes, Set<Integer> pf) {
        for (int prime : primes) {
            if (num == prime) {
                pf.add(prime);
                return;
            }
        }
        boolean found = false;
        for (int prime : primes) {
            if (num % prime == 0) {
                pf.add(prime);
                isUgly(num / prime, primes, pf);
                found = true;
                break;
            }
        }
        if (!found) {
            pf.add(num);
        }
    }

    public static void main(String[] args) {
        Problem264 prob = new Problem264();
        System.out.println(prob.nthUglyNumber(9));
        System.out.println(prob.nthUglyNumber(312));
    }
}
