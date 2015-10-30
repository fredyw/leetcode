package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/ugly-number-ii/
 */
public class Problem264 {
    public int nthUglyNumber(int n) {
        int x = (int) (Math.log10(n) / Math.log10(3)) + 3;
        Set<Integer> processed = new HashSet<>();
        Set<Integer> uglyNumbers = new TreeSet<>();
        uglyNumbers.add(1);
        List<Integer> level = new ArrayList<>();
        level.add(1);
        for (int i = 0; i < x; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int num : level) {
                int a = num * 2;
                if (!processed.contains(a)) {
                    tmp.add(a);
                    processed.add(a);
                    uglyNumbers.add(a);
                }
                int b = num * 3;
                if (!processed.contains(b)) {
                    tmp.add(b);
                    processed.add(b);
                    uglyNumbers.add(b);
                }
                int c = num * 5;
                if (!processed.contains(c)) {
                    tmp.add(c);
                    processed.add(c);
                    uglyNumbers.add(c);
                }
            }
            level = tmp;
            System.out.println(level);
        }
        System.out.println(uglyNumbers);
        int i = 1;
        for (int num : uglyNumbers) {
            if (i == n) {
                return num;
            }
            i++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Problem264 prob = new Problem264();
//        System.out.println(prob.nthUglyNumber(7)); // 8
//        System.out.println(prob.nthUglyNumber(9)); // 10
        System.out.println(prob.nthUglyNumber(19)); // 32
//        System.out.println(prob.nthUglyNumber(312));
    }
}
