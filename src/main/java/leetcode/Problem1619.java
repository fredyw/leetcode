package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/mean-of-array-after-removing-some-elements/
 */
public class Problem1619 {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        double j = arr.length * 0.05;
        double sum = 0;
        for (int i = (int) j; i < arr.length - j; i++) {
            sum += arr[i];
        }
        return sum / (arr.length - (j * 2));
    }
}
