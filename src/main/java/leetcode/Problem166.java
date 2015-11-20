package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/fraction-to-recurring-decimal/
 */
public class Problem166 {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator % denominator == 0) {
            return Integer.toString(numerator / denominator);
        }
        String val = Double.toString((double) numerator / (double) denominator);
//        System.out.println("val=" + val);
        String[] splitNum = val.split("\\.");
        String num = splitNum[0];
        String fraction = splitNum[1];
        String prev = "";
        int idx = 0;
        long frac = Long.parseLong(fraction);
        if (isPrimeFactor(frac)) {
            return val;
        }
        for (char c : fraction.toCharArray()) {
            if (!prev.isEmpty()) {
                if (idx == prev.length()) {
                    break;
                }
                if (prev.charAt(idx) == c) {
                    idx++;
                } else {
                    idx = 0;
                    prev += c;
                }
            } else {
                prev += c;
            }
        }
        return num + ".(" + prev + ")";
    }

    private boolean isPrimeFactor(long num) {
        // https://en.wikipedia.org/wiki/Repeating_decimal
        long[] primes = new long[]{2, 5};
        Set<Long> pf = new HashSet<>();
        isPrimeFactor(num, primes, pf);
        for (long prime : primes) {
            pf.remove(prime);
        }
        return pf.isEmpty();
    }

    private void isPrimeFactor(long num, long[] primes, Set<Long> pf) {
        for (long prime : primes) {
            if (num == prime) {
                pf.add(prime);
                return;
            }
        }
        boolean found = false;
        for (long prime : primes) {
            if (num % prime == 0) {
                pf.add(prime);
                isPrimeFactor(num / prime, primes, pf);
                found = true;
                break;
            }
        }
        if (!found) {
            pf.add(num);
        }
    }

    public static void main(String[] args) {
        Problem166 prob = new Problem166();
//        System.out.println(prob.fractionToDecimal(1, 2)); // 0.5
//        System.out.println(prob.fractionToDecimal(2, 1)); // 2
//        System.out.println(prob.fractionToDecimal(2, 3)); // 0.(6)
//        System.out.println(prob.fractionToDecimal(22, 7)); // 3.(142857)
//        System.out.println(prob.fractionToDecimal(1, 400)); // 0.0025
//        System.out.println(prob.fractionToDecimal(1, 9)); // 0.(1)
//        System.out.println(prob.fractionToDecimal(1, 3)); // 0.(3)
//        System.out.println(prob.fractionToDecimal(9, 11)); // 0.(81)
//        System.out.println(prob.fractionToDecimal(7, 12)); // 0.58(3)
//        System.out.println(prob.fractionToDecimal(1, 81)); // 0.(0123456798)
        System.out.println(prob.fractionToDecimal(1, 214748364)); // 0.00(000000465661289042462740251655654056577585848337359161441621040707904997124914069194026549138227660723878669455195477065427143370461252966751355553982241280310754777158628319049732085502639731402098131932683780538602845887105337854867197032523144157689601770377165713821223802198558308923834223016478952081795603341592860749337303449725)
    }
}
