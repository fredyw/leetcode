package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class Problem4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int size = nums1.length + nums2.length;
        boolean odd = true;
        if (size % 2 == 0) {
            odd = false;
        }
        int mid = (nums1.length + nums2.length) / 2;
        if (!odd) {
            mid--;
        }
        int k = 0;
        boolean found = false;
        List<Integer> vals = new ArrayList<>();
        outer:
        while (true) {
            while (i < nums1.length && j < nums2.length && nums1[i] <= nums2[j]) {
                if (k == mid) {
                    vals.add(nums1[i]);
                    if (odd || (!odd && vals.size() == 2)) {
                        found = true;
                    }
                    if (found) {
                        break outer;
                    }
                    mid++;
                }
                k++;
                i++;
            }
            if (i == nums1.length) {
                break;
            }
            while (i < nums1.length && j < nums2.length && nums1[i] > nums2[j]) {
                if (k == mid) {
                    vals.add(nums2[j]);
                    if (odd || (!odd && vals.size() == 2)) {
                        found = true;
                    }
                    if (found) {
                        break outer;
                    }
                    mid++;
                }
                k++;
                j++;
            }
            if (j == nums2.length) {
                break;
            }
        }

        if (!found) {
            while (i < nums1.length) {
                if (k == mid) {
                    vals.add(nums1[i]);
                    if (odd || (!odd && vals.size() == 2)) {
                        found = true;
                    }
                    if (found) {
                        break;
                    }
                    mid++;
                }
                k++;
                i++;
            }
        }

        if (!found) {
            while (j < nums2.length) {
                if (k == mid) {
                    vals.add(nums2[j]);
                    if (odd || (!odd && vals.size() == 2)) {
                        found = true;
                    }
                    if (found) {
                        break;
                    }
                    mid++;
                }
                k++;
                j++;
            }
        }
        if (odd) {
            return vals.get(0);
        }
        return (vals.get(0) + vals.get(1)) / 2.0;
    }
}
