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
        return answer;
    }

    public static void main(String[] args) {
        Problem1775 prob = new Problem1775();
//        System.out.println(prob.minOperations(new int[]{1,2,3,4,5,6}, new int[]{1,1,2,2,2,2})); // 3
//        System.out.println(prob.minOperations(new int[]{1,1,1,1,1,1,1}, new int[]{6})); // -1
//        System.out.println(prob.minOperations(new int[]{6,6}, new int[]{1})); // 3
//        System.out.println(prob.minOperations(new int[]{6,6,5}, new int[]{1,1})); // 3
//        System.out.println(prob.minOperations(new int[]{1,1}, new int[]{6,6,5})); // 3
//        System.out.println(prob.minOperations(new int[]{6,6,5}, new int[]{1,1,1})); // 3
        System.out.println(prob.minOperations(new int[]{5,6,4,3,1,2}, new int[]{6,3,3,1,4,5,3,4,1,3,4})); // 4
    }
}
