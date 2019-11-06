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
                            // Example:
                            // xx
                            // yy
                            int index = x1Set.iterator().next(); // pick any y from s1
                            x1Set.remove(index);
                            y2Set.remove(index);
                            answer++;
                        } else if (!x2Set.isEmpty()) {
                            // Example:
                            // xy
                            // yx
                            int index = x2Set.iterator().next(); // pick any x from s2
                            x2Set.remove(index);
                            y1Set.remove(index);
                            answer += 2;
                        } else {
                            return -1;
                        }
                    }
                } else {
                    if (y1Set.remove(i) && x2Set.remove(i)) {
                        if (!y1Set.isEmpty()) {
                            // Example:
                            // yy
                            // xx
                            int index = y1Set.iterator().next(); // pick any y from s1
                            y1Set.remove(index);
                            x2Set.remove(index);
                            answer++;
                        } else if (!y2Set.isEmpty()) {
                            // Example:
                            // yx
                            // xy
                            int index = y2Set.iterator().next(); // pick any y from the s2
                            x1Set.remove(index);
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
}
