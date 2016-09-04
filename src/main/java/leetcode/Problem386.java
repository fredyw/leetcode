package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/lexicographical-numbers/
 */
public class Problem386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            if (i > n) {
                break;
            }
            lexicalOrder(n, 1, 1, new IntRef(), result);
        }
        return result;
    }

    private static class IntRef {
        int counter;
    }

    private void lexicalOrder(int n, int multiplier, int accu, IntRef ref, List<Integer> result) {
        int newNumber = multiplier * accu;
        if (newNumber > n) {
            return;
        }
        for (int i = 0; i <= 9; i++) {
            int newAccu = newNumber + i;
            if (newAccu > n || ref.counter == n) {
                break;
            }
            result.add(newAccu);
            ref.counter++;
            lexicalOrder(n, 10, newAccu, ref, result);
        }
    }
}
