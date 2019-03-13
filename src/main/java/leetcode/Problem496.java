package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/next-greater-element-i/
 */
public class Problem496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] answer = new int[nums1.length];
        return answer;
    }

    public static void main(String[] args) {
        Problem496 prob = new Problem496();
//        System.out.println(prob.nextGreaterElement(new int[]{1, 5, 10}, new int[]{2, 3, 7, 11}));
        System.out.println(Arrays.toString(prob.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
//        System.out.println(Arrays.toString(prob.nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4})));
    }
}
