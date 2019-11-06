package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/
 */
public class Problem1247 {
    public int minimumSwap(String s1, String s2) {
        Set<Integer> xSet = new HashSet<>();
        Set<Integer> ySet = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (s1.charAt(i) == 'x') {
                    xSet.add(i);
                } else {
                    ySet.add(i);
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (s1.charAt(i) == 'x') {
                    if (xSet.size() > 1) {
                        xSet.remove(i);
                        ySet.remove(i);
                        int index = xSet.iterator().next();
                        xSet.remove(index);
                        ySet.remove(index);
                        answer++;
                    }
                } else {
                    if (ySet.size() > 1) {
                        xSet.remove(i);
                        ySet.remove(i);
                        int index = ySet.iterator().next();
                        xSet.remove(index);
                        ySet.remove(index);
                        answer++;
                    }
                }
            }
        }
        return xSet.isEmpty() && ySet.isEmpty() ? answer : -1;
    }

    public static void main(String[] args) {
        Problem1247 prob = new Problem1247();
        System.out.println(prob.minimumSwap("xx", "yy")); // 1
        System.out.println(prob.minimumSwap("xy", "yx")); // 2
        System.out.println(prob.minimumSwap("xx", "xy")); // -1
        System.out.println(prob.minimumSwap("xxyyxyxyxx", "xyyxyxxxyx")); // 4
    }
}
