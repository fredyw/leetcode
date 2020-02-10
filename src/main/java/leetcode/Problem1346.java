package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/check-if-n-and-its-double-exist/
 */
public class Problem1346 {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int nZero = 0;
        for (int n : arr) {
            if (n == 0) {
                nZero++;
            }
            set.add(n);
        }
        if (nZero > 1) {
            return true;
        }
        for (int n : arr) {
            if (n == 0) {
                continue;
            }
            if (n % 2 == 0 && set.contains(n / 2)) {
                return true;
            }
        }
        return false;
    }
}
