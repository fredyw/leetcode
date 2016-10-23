package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/arithmetic-slices/
 */
public class Problem413 {
    public int numberOfArithmeticSlices(int[] A) {
        List<Integer> lengths = new ArrayList<>();
        int countDiff = 1;
        Integer prevDiff = null;
        for (int i = 0; i < A.length - 1; i++) {
            int diff = A[i] - A[i + 1];
            if (prevDiff != null && prevDiff == diff) {
                countDiff++;
            } else {
                if (countDiff >= 2) {
                    lengths.add(countDiff + 1);
                }
                prevDiff = diff;
                countDiff = 1;
            }
        }
        if (countDiff >= 2) {
            lengths.add(countDiff + 1);
        }
        int result = 0;
        Map<Integer, Integer> memo = new HashMap<>();
        for (int length : lengths) {
            if (memo.containsKey(length)) {
                result += memo.get(length);
            } else {
                int total = 0;
                for (int step = 3; step <= length; step++) {
                    total++;
                    for (int i = 0; i + step < length; i++) {
                        total++;
                    }
                }
                result += total;
                memo.put(length, total);
            }
        }
        return result;
    }
}
