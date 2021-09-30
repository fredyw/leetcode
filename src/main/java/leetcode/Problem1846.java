package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/
 */
public class Problem1846 {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                if (arr[i] != 1) {
                    arr[i] = 1;
                }
            } else {
                if (arr[i - 1] != arr[i] && arr[i - 1] != arr[i] + 1) {
                    arr[i] = arr[i - 1] + 1;
                }
            }
        }
        return arr[arr.length - 1];
    }
}
