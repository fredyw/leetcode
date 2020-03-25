package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/sort-integers-by-the-power-value/
 */
public class Problem1387 {
    public int getKth(int lo, int hi, int k) {
        List<IntPower> list = new ArrayList<>();
        for (int i = lo; i <= hi; i++) {
            list.add(new IntPower(i, getPowerOfValue(i)));
        }
        Collections.sort(list, (a, b) -> {
            int cmp = Integer.compare(a.power, b.power);
            if (cmp == 0) {
                return Integer.compare(a.number, b.number);
            }
            return cmp;
        });
        return list.get(k - 1).number;
    }

    private static int getPowerOfValue(int x) {
        int step = 0;
        while (x > 1) {
            if (x % 2 == 0) {
                x /= 2;
            } else {
                x = 3 * x + 1;
            }
            step++;
        }
        return step;
    }

    private static class IntPower {
        private final int number;
        private final int power;

        public IntPower(int number, int power) {
            this.number = number;
            this.power = power;
        }
    }
}
