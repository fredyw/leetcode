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
//            System.out.println("i = " + i);
//            System.out.println("  - popping " + result);
//            System.out.println("  - primeIdx: " + primeIdx);
            for (int j = 0; j <= primeIdx; j++) {
//                System.out.println("  - adding " + (result * primes[j]));
                set.add(result * primes[j]);
//                System.out.println("  - set: " + set);
            }
            i++;
            if (primeIdx < primes.length - 1) {
                primeIdx++;
            }
        }
        return (int) result;
    }

    public static void main(String[] args) {
        Problem313 prob = new Problem313();
        System.out.println(prob.nthSuperUglyNumber(12, new int[]{2, 7, 13, 19})); // 32
        System.out.println(prob.nthSuperUglyNumber(15, new int[]{3, 5, 7, 11, 19, 23, 29, 41, 43, 47})); // 35
        System.out.println(prob.nthSuperUglyNumber(100000, new int[]{7,19,29,37,41,47,53,59,61,79,83,89,101,103,109,127,131,137,139,157,167,179,181,199,211,229,233,239,241,251})); // 1092889481
    }
}
