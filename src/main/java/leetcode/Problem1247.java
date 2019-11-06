package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/
 */
public class Problem1247 {
    public int minimumSwap(String s1, String s2) {
        Set<Integer> x1Set = new HashSet<>();
        Set<Integer> y1Set = new HashSet<>();
        Set<Integer> x2Set = new HashSet<>();
        Set<Integer> y2Set = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (s1.charAt(i) == 'x') {
                    x1Set.add(i);
                    y2Set.add(i);
                } else {
                    y1Set.add(i);
                    x2Set.add(i);
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (s1.charAt(i) == 'x') {
                    if (x1Set.remove(i) && y2Set.remove(i)) {
                        if (!x1Set.isEmpty()) {
                            int index = x1Set.iterator().next();
                            x1Set.remove(index);
                            x2Set.remove(index);
                            y1Set.remove(index);
                            y2Set.remove(index);
                            answer++;
                        } else if (!x2Set.isEmpty()) {
                            int index = x2Set.iterator().next();
                            x1Set.remove(index);
                            x2Set.remove(index);
                            y1Set.remove(index);
                            y2Set.remove(index);
                            answer += 2;
                        } else {
                            return -1;
                        }
                    }
                } else {
                    if (y1Set.remove(i) && x2Set.remove(i)) {
                        if (!y1Set.isEmpty()) {
                            int index = y1Set.iterator().next();
                            x1Set.remove(index);
                            x2Set.remove(index);
                            y1Set.remove(index);
                            y2Set.remove(index);
                            answer++;
                        } else if (!y2Set.isEmpty()) {
                            int index = y2Set.iterator().next();
                            x1Set.remove(index);
                            x2Set.remove(index);
                            y1Set.remove(index);
                            y2Set.remove(index);
                            answer += 2;
                        } else {
                            return -1;
                        }
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem1247 prob = new Problem1247();
        System.out.println(prob.minimumSwap("xx", "yy")); // 1
        System.out.println(prob.minimumSwap("xy", "yx")); // 2
        System.out.println(prob.minimumSwap("xx", "xy")); // -1
        System.out.println(prob.minimumSwap("xx", "xx")); // 0
        System.out.println(prob.minimumSwap("xxyyxyxyxx", "xyyxyxxxyx")); // 4
    }
}
