package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/
 */
public class Problem1502 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }
        return true;
    }
}
