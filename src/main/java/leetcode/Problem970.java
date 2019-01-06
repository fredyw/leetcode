package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/powerful-integers/
 */
public class Problem970 {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= bound; i++) {
            int a = (int) Math.pow(x, i);
            if (a > bound) {
                break;
            }
            for (int j = 0; j <= bound; j++) {
                int b = (int) Math.pow(y, j);
                int c = a + b;
                if (c > bound) {
                    break;
                } else {
                    set.add(c);
                }
            }
        }
        return new ArrayList<>(set);
    }
}
