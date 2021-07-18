package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/equal-sum-arrays-with-minimum-number-of-operations/
 */
public class Problem1775 {
    public int minOperations(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length && 6 * nums1.length < nums2.length) {
            return -1;
        } else if (nums1.length > nums2.length && nums1.length > 6 * nums2.length) {
            return -1;
        }
        int sum1 = 0;
        for (int num : nums1) {
            sum1 += num;
        }
        int sum2 = 0;
        for (int num : nums2) {
            sum2 += num;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int answer = 0;
        if (sum1 < sum2) {
            int i = 0;
            int j = nums2.length - 1;
            while (sum1 < sum2) {
                if (i < nums1.length && 6 - nums1[i] >= nums2[j] - 1) {
                    sum1 += 6 - nums1[i++];
                } else {
                    sum2 -= nums2[j--] - 1;
                }
                answer++;
            }
        } else if (sum1 > sum2) {
            int i = nums1.length - 1;
            int j = 0;
            while (sum1 > sum2) {
                if (i >= 0 && nums1[i] - 1 >= 6 - nums2[j]) {
                    sum1 -= nums1[i--] - 1;
                } else {
                    sum2 += 6 - nums2[j++];
                }
                answer++;
            }
        }
        return answer;
    }
}
