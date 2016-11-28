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
            while (i < nums1.length && nums1[i] <= nums2[j]) {
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
            while (j < nums2.length && nums1[i] > nums2[j]) {
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

    public static void main(String[] args) {
        Problem4 prob = new Problem4();
        System.out.println(prob.findMedianSortedArrays(new int[]{1, 3}, new int[]{2})); // 2.0
        System.out.println(prob.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4})); // 2.5
        System.out.println(prob.findMedianSortedArrays(new int[]{1, 3, 7, 10, 12}, new int[]{8, 9, 11})); // 8.5
        System.out.println(prob.findMedianSortedArrays(new int[]{1, 3, 7, 10}, new int[]{11, 13})); // 8.5
        System.out.println(prob.findMedianSortedArrays(new int[]{7, 10, 12}, new int[]{1, 2})); // 7
        System.out.println(prob.findMedianSortedArrays(new int[]{7, 10, 12}, new int[]{1, 2, 6})); // 6.5
        System.out.println(prob.findMedianSortedArrays(new int[]{7, 8, 10, 12}, new int[]{1, 2})); // 7.5
        System.out.println(prob.findMedianSortedArrays(new int[]{2}, new int[]{0})); // 2
        System.out.println(prob.findMedianSortedArrays(new int[]{0}, new int[]{2})); // 2
    }
}
