package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/fair-candy-swap/
 */
public class Problem888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        for (int a : A) {
            sumA += a;
        }
        Set<Integer> setB = new HashSet<>();
        int sumB = 0;
        for (int b : B) {
            sumB += b;
            setB.add(b);
        }
        // Formula:
        // sumA - a + b = sumB - b + a
        // 2b = sumB - sumA + 2a
        // b = (sumB - sumA + 2a) / 2
        int[] result = new int[2];
        outer:
        for (int a : A) {
            int b = (sumB - sumA + (2 * a)) / 2;
            if (setB.contains(b)) {
                result[0] = a;
                result[1] = b;
                break;
            }
        }
        return result;
    }
}
