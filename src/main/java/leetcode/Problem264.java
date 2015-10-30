package leetcode;

import java.util.TreeSet;

/**
 * https://leetcode.com/problems/ugly-number-ii/
 */
public class Problem264 {
    public int nthUglyNumber(int n) {
        TreeSet<Long> uglyNumbers = new TreeSet<>();
        uglyNumbers.add(1l);
        for (long i = 1; i < n; i++) {
            long j = uglyNumbers.pollFirst();
            uglyNumbers.add(j * 2);
            uglyNumbers.add(j * 3);
            uglyNumbers.add(j * 5);
        }
        return uglyNumbers.first().intValue();
    }
}
