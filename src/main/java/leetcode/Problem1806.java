package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-number-of-operations-to-reinitialize-a-permutation/
 */
public class Problem1806 {
    public int reinitializePermutation(int n) {
        int[] initial = new int[n];
        for (int i = 0; i < n; i++) {
            initial[i] = i;
        }
        int answer = 0;
        int[] array = initial;
        while (true) {
            int[] tmp = new int[n];
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    tmp[i] = array[i / 2];
                } else {
                    tmp[i] = array[(n / 2 + (i - 1) / 2)];
                }
            }
            array = tmp;
            answer++;
            if (Arrays.equals(initial, tmp)) {
                return answer;
            }
        }
    }
}
