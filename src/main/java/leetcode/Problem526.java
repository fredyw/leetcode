package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/beautiful-arrangement/
 */
public class Problem526 {
    public int countArrangement(int N) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            numbers.add(i);
        }
        IntRef result = new IntRef();
        countArrangement(numbers, new HashSet<>(), 1, result);
        return result.ref;
    }

    private static class IntRef {
        int ref;
    }

    private static void countArrangement(List<Integer> numbers,
                                         Set<Integer> processed,
                                         int count,
                                         IntRef result) {
        if (count > numbers.size()) {
            result.ref++;
            return;
        }
        for (int i = 0; i < numbers.size(); i++) {
            int val = numbers.get(i);
            if (processed.contains(val)) {
                continue;
            }
            if (val % count == 0 || count % val == 0) {
                processed.add(val);
                countArrangement(numbers, processed, count + 1, result);
                // backtracking
                processed.remove(val);
            }
        }
    }

    public static void main(String[] args) {
        Problem526 prob = new Problem526();
        System.out.println(prob.countArrangement(2)); // 2
        System.out.println(prob.countArrangement(3)); // 2
        System.out.println(prob.countArrangement(10)); // 700
        System.out.println(prob.countArrangement(15)); // 24679
    }
}
