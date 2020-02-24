package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
 */
public class Problem1356 {
    public int[] sortByBits(int[] arr) {
        ValueCount[] vc = new ValueCount[arr.length];
        for (int i = 0; i < arr.length; i++) {
            vc[i] = new ValueCount(arr[i], numOnes(arr[i]));
        }
        Arrays.sort(vc, (a, b) -> {
            int cmp = Integer.compare(a.count, b.count);
            if (cmp == 0) {
                return Integer.compare(a.value, b.value);
            }
            return cmp;
        });
        int[] answer = new int[arr.length];
        for (int i = 0; i < vc.length; i++) {
            answer[i] = vc[i].value;
        }
        return answer;
    }

    private static class ValueCount {
        private final int value;
        private final int count;

        public ValueCount(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    private static int numOnes(int n) {
        int count = 0;
        int num = n;
        while (num > 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num >>= 1;
        }
        return count;
    }
}
