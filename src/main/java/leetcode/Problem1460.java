package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/
 */
public class Problem1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }
}
