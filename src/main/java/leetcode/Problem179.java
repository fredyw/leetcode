package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/largest-number/
 */
public class Problem179 {
    public String largestNumber(int[] num) {
        StringBuilder result = new StringBuilder();
        List<Integer> numbers = new ArrayList<>(num.length);
        for (int n : num) {
            numbers.add(n);
        }
        Collections.sort(numbers, (Integer o1, Integer o2) -> {
            Integer s1 = Integer.valueOf(o1.toString() + o2.toString());
            Integer s2 = Integer.valueOf(o2.toString() + o1.toString());
            return s1.compareTo(s2);
        });
        int zero = numbers.size() - 1;
        for (int i = numbers.size() - 1; i >= 0; i--) {
            if (i == zero && i != 0 && numbers.get(i).equals(0)) {
                zero--;
                continue;
            }
            result.append(numbers.get(i));
        }
        return result.toString();
    }
}
