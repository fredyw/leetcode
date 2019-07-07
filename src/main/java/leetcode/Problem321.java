package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/create-maximum-number/
 */
public class Problem321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        char[] chars = maxNumber(nums1, nums2, k, 0, 0, "", new String[nums1.length + 1][nums2.length + 1]).toCharArray();
        int[] answer = new int[chars.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = chars[i] - '0';
        }
        return answer;
    }

    private static String maxNumber(int[] nums1, int[] nums2, int k, int i, int j, String accu,
                                    String[][] memo) {
        if (accu.length() == k) {
            return accu;
        }
        long max = 0;
        if (i < nums1.length && j < nums2.length) {
            long a = Long.parseLong(maxNumber(nums1, nums2, k, i + 1, j + 1,
                accu + (nums1[i] > nums2[j] ? nums1[i] : nums2[j]), memo));
            long b = Long.parseLong(maxNumber(nums1, nums2, k, i + 1, j, accu, memo));
            long c = Long.parseLong(maxNumber(nums1, nums2, k, i + 1, j, accu + nums1[i], memo));
            long d = Long.parseLong(maxNumber(nums1, nums2, k, i, j + 1, accu, memo));
            long e = Long.parseLong(maxNumber(nums1, nums2, k, i, j + 1, accu + nums2[j], memo));
            max = Math.max(a, Math.max(b, Math.max(c, Math.max(d, e))));
        } else if (i < nums1.length) {
            long a = Long.parseLong(maxNumber(nums1, nums2, k, i + 1, j, accu, memo));
            long b = Long.parseLong(maxNumber(nums1, nums2, k, i + 1, j, accu + nums1[i], memo));
            max = Math.max(a, b);
        } else if (j < nums2.length) {
            long a = Long.parseLong(maxNumber(nums1, nums2, k, i, j + 1, accu, memo));
            long b = Long.parseLong(maxNumber(nums1, nums2, k, i, j + 1, accu + nums2[j], memo));
            max = Math.max(a, b);
        }
        return Long.toString(max);
    }

    public static void main(String[] args) {
        Problem321 prob = new Problem321();
        System.out.println(Arrays.toString(prob.maxNumber(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5))); // [9, 8, 6, 5, 3]
        System.out.println(Arrays.toString(prob.maxNumber(new int[]{6, 7}, new int[]{6, 0, 4}, 5))); // [6, 7, 6, 0, 4]
        System.out.println(Arrays.toString(prob.maxNumber(new int[]{3, 9}, new int[]{8, 9}, 3))); // [9, 8, 9]
        System.out.println(Arrays.toString(prob.maxNumber(new int[]{9, 8, 7}, new int[]{1, 2}, 4))); // [9, 8, 7, 2]
    }
}
