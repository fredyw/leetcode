package leetcode;

import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/find-k-closest-elements/
 */
public class Problem658 {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        int idx = Collections.binarySearch(arr, x);
        if (idx < 0) {
            idx = (-idx) - 1;
        }
        int left = idx - 1;
        int right = idx;
        while (k > 0) {
            int diff1 = Integer.MAX_VALUE;
            if (left >= 0) {
                diff1 = x - arr.get(left);
            }
            int diff2 = Integer.MAX_VALUE;
            if (right < arr.size()) {
                diff2 = arr.get(right) - x;
            }
            if (diff1 <= diff2) {
                left--;
            } else {
                right++;
            }
            k--;
        }
        left++;
        return arr.subList(left, right);
    }
}
